package com.sandun.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.ArrayList;

// Define variables in Allocation Class
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllocationCheckHistory {
    @Id
    private Long id;
    private Integer orderId;
    private Integer allocAmount; 
    private String status;
    private Boolean isStockAvailable;
    private ArrayList<Integer> createdAt;

}
