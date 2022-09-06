package com.sandun.allocation;

public record UpdateStockmessage(
        Integer availableStock,
        Integer allocatedAmount) {
}