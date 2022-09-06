package com.sandun.dispatch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Dispatch")
public class Dispatch {
    @Id
    @SequenceGenerator(
            name = "dispatch_id_sequence",
            sequenceName = "dispatch_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dispatch_id_sequence"
    )
    private Integer dispatchId;
    private Integer orderId;
    private String status;
    private Integer allocAmount;
    private LocalDateTime createdAt;
    private LocalDateTime dispatchAt;
    private Boolean isDispatched;
}
