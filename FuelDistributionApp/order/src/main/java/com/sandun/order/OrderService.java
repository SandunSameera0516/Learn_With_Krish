package com.sandun.order;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    KafkaTemplate<String,Order> kafkaTemplate;
    public void placeOrder(OrderRequest orderRequest) {

        Order order = Order.builder()
                .status("Order is created")
                .createdAt(LocalDateTime.now())
                .allocAmount(orderRequest.allocAmount())
                .build();
        //todo: check the allocation is available or not
        //send order details to allocation service to check weather stock is available or not
        Message<Order> message = MessageBuilder.withPayload(order)
                .setHeader(KafkaHeaders.TOPIC,"mainTopic")
                .build();
        //  Store to database
        orderRepository.save(order);
        //  Send to kafka Topic
        kafkaTemplate.send(message);
    }

}
