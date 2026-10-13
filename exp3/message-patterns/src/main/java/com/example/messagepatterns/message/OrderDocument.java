package com.example.messagepatterns.message;

public record OrderDocument(
        Long orderId,
        String customerName,
        String productName,
        int quantity,
        double price,
        String status
) {
}