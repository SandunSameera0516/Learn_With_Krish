package com.sandun.schedule;

import com.sandun.schedule.entity.AllocationCheckHistory;
import com.sandun.schedule.entity.Schedule;
import com.google.gson.*;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    KafkaTemplate<String, Schedule> kafkaTemplate;

    @KafkaListener(topics = "secondTopic", groupId = "groupId")
    public void scheduleOrder(String data){

//      note: In here Data Is Received But LocalDateAndTime in ArrayListFormat
        Gson g = new Gson();
        AllocationCheckHistory a = g.fromJson(data,AllocationCheckHistory.class);

//      Converting ArrayList To LocalDateAndTime
        List<Integer> date = a.getCreatedAt();
        LocalDateTime createdAt =LocalDateTime.of(date.get(0),date.get(1),date.get(2), date.get(3),date.get(4),date.get(5),date.get(6));
        System.out.println(createdAt);

        Schedule schedule = Schedule.builder()
                .orderId(a.getOrderId())
                .allocAmount(a.getAllocAmount())
                .status("Order Scheduled")
                .createdAt(createdAt)
                .scheduleTime(LocalDateTime.now().plusDays(5))
                .build();
        scheduleRepository.save(schedule);

        Message<Schedule> message = MessageBuilder.withPayload(schedule)
                .setHeader(KafkaHeaders.TOPIC,"thirdTopic")
                .build();
        kafkaTemplate.send(message);
    }
}
