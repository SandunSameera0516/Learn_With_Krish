package com.sandun.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Order")
// order class
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_sequence"
    )
    private Integer orderId;
    private Integer allocAmount;
    private String status;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAllocAmount() {
        return allocAmount;
    }

    public void setAllocAmount(Integer allocAmount) {
        this.allocAmount = allocAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", allocAmount=" + allocAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
