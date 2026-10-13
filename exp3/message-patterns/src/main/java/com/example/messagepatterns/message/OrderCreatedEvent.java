package com.example.messagepatterns.message;

import java.time.LocalDateTime;

public record OrderCreatedEvent(
        Long orderId,
        String customerName,
        String productName,
        int quantity,
        double price,
        LocalDateTime createdAt
) {
}