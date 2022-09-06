package com.sandun.dispatch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    private Integer scheduleId;
    private Integer orderId;
    private Integer allocAmount;
    private String status;
    private ArrayList<Integer> createdAt;
    private ArrayList<Integer>  scheduleTime;
}
