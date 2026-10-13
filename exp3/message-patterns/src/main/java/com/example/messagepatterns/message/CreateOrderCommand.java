package com.example.messagepatterns.message;

public record CreateOrderCommand(
        String customerName,
        String productName,
        int quantity,
        double price
) {
}