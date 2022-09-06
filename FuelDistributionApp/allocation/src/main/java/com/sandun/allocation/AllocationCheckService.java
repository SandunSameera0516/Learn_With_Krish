package com.sandun.allocation;

import com.sandun.allocation.entity.AllocationCheckHistory;
import com.sandun.allocation.entity.Order;
import com.sandun.allocation.entity.Stock;
import com.sandun.allocation.repo.AllocationCheckHistoryRepositry;
import com.sandun.allocation.repo.StockRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// In Here We Save the Values To the Database
@Service
@AllArgsConstructor
public class AllocationCheckService {

    private final AllocationCheckHistoryRepositry allocationCheckHistoryRepositry;
    private final StockRepository stockRepository;

    static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    KafkaTemplate<String,AllocationCheckHistory> kafkaTemplate;

    //Read the Kafka Object
    //Note: this is only used for one message at a time
    //todo: need to change the code to handle multiple requests at a time
    @KafkaListener(topics = "mainTopic", groupId = "groupId")
    public void listenerForOrder (String data) {
    //Converting Sting to Json of Particular Object
        Gson g = new Gson();
        Order o = g.fromJson(data,Order.class);

       //finding the last entered value
        List<Stock> st = stockRepository.findByIdDESC();
       //Getting the object from ArrayList
        Stock sto = st.get(0);

       //Getting the values that we need to compare
        Integer alreadyAllocatedStock = sto.getAllocatedAmount();
        Integer availableStock = sto.getAvailableStock();
        Integer allocationstock = o.getAllocAmount();
        Boolean checkStock = checkStock(availableStock,allocationstock,alreadyAllocatedStock);

        //Saving the values to allocation History table by checking Weather the Stock is available or not
        //todo: if the stock is not available need to send the message to client as "Out of Stock"
        System.out.println("Listener received json: " + o);
        AllocationCheckHistory allocationCheckHistory = AllocationCheckHistory
                .builder()
                .orderId(o.getOrderId())
                .allocAmount(o.getAllocAmount())
                .status(checkStatus(checkStock)) //todo: if the isStockAvailbe is false status should be "out of stock" else "Order Allocated"
                .createdAt(LocalDateTime.now())
                .isStockAvailable(checkStock)   //Checking whether the stock is available or not
                .build();
        allocationCheckHistoryRepositry.save(allocationCheckHistory); // todo: if stock is not Available what to do???

        Message<AllocationCheckHistory> message = MessageBuilder.withPayload(allocationCheckHistory)
                .setHeader(KafkaHeaders.TOPIC,"secondTopic")
                .build();
        kafkaTemplate.send(message);

    }

    //updating Stock From Post Mapping From Admin Side (Initial Built)
    //todo: Make sure the Admin the only person can change this
    public void stockUpdate(UpdateStockmessage updateStockmessage){
        List<Stock> st = stockRepository.findByIdDESC();

    //Checks weather stock table is empty or not if its empty "save the stock" else "update the stock"
        if (st.isEmpty() == true){
            Stock stock = Stock.builder()
                    .allocatedAmount(updateStockmessage.allocatedAmount())
                    .availableStock(updateStockmessage.availableStock())
                    .build();
            stockRepository.save(stock);
        }else{
            Stock sto = st.get(0);

            Integer alreadyAllocatedStock = sto.getAllocatedAmount();
            Integer availableStock = sto.getAvailableStock();
            Integer TotalStock = availableStock + updateStockmessage.availableStock();
            Integer TotalAllocation = alreadyAllocatedStock + updateStockmessage.allocatedAmount();

            Stock stock = Stock.builder()
                    .allocatedAmount(TotalAllocation)
                    .availableStock(TotalStock)
                    .build();
            stockRepository.save(stock);
        }
    }

    //Function for Checking the Stock available or not and updating stock Table
    public Boolean checkStock(Integer availableStock,Integer allocationstock, Integer alreadyAllocatedStock){
        if (availableStock >=  allocationstock){
            Integer balanceStock = availableStock-allocationstock;
            Integer TotalAllocation = alreadyAllocatedStock+allocationstock;
            Stock stock = Stock.builder()
                    .allocatedAmount(TotalAllocation)
                    .availableStock(balanceStock)
                    .build();
            stockRepository.save(stock);
            return true;
        }
        else
            return false; //todo: throw an error if stock is not available "Out of Stock"
    }
    public String checkStatus(Boolean checkStock){
        if (checkStock == true){
            return "Order Allocated";
        }else {
            return "Allocation Fail";
        }
    }
}
