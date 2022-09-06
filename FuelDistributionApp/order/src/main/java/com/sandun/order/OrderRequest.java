package com.sandun.order;

public record OrderRequest(
        Integer allocAmount,
        String status) {
}
