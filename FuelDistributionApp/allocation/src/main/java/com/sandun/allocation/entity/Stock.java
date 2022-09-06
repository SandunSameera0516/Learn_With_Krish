package com.sandun.allocation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Stock Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Stock")
public class Stock {
    @Id
    @SequenceGenerator(
            name = "stock_id_sequence",
            sequenceName = "stock_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_id_sequence"
    )
    private Integer id;
    private Integer availableStock;
    private Integer allocatedAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }

    public Integer getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(Integer allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", availableStock=" + availableStock +
                ", allocatedAmount=" + allocatedAmount +
                '}';
    }
}
