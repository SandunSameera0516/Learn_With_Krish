package com.sandun.dispatch;

import com.google.gson.Gson;
import com.sandun.dispatch.entity.Dispatch;
import com.sandun.dispatch.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DispatchService {
    //todo: Need To Find a Way To make the Order Dispatch on the Scheduled date
    private final DispatchRepository dispatchRepository;

    @KafkaListener(topics = "thirdTopic", groupId = "groupId")
    public void dispatchOrder(String data){
        Gson g = new Gson();
        Schedule a = g.fromJson(data,Schedule.class);

        //Get Scheduled Date
        List<Integer> scdate = a.getScheduleTime();
        LocalDateTime scheduledTime =LocalDateTime.of(scdate.get(0),scdate.get(1),scdate.get(2), scdate.get(3),scdate.get(4),scdate.get(5),scdate.get(6));
        System.out.println(scheduledTime);
        //Check Whether the order can be dispatched or not
        //Update Status According to the Check
        Boolean isDispatched = isDispatched(scheduledTime);

        Dispatch dispatch = Dispatch.builder()
                .orderId(a.getOrderId())
                .allocAmount(a.getAllocAmount())
                .createdAt(LocalDateTime.now())
                .dispatchAt(scheduledTime)
                .isDispatched(isDispatched)
                .status(checkStatus(isDispatched))
                .build();
        dispatchRepository.save(dispatch);
    }
    public Boolean isDispatched(LocalDateTime scheduledTime){
        if (LocalDateTime.now()== scheduledTime){
            return true;
        }else {
            return false;
        }
    }

    public String checkStatus(Boolean isDispatched){
        if (isDispatched == true){
            return "Order Dispatched";
        }else {
            return "Order is not Dispatched";
        }
    }
}