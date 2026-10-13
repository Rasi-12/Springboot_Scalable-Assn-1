package com.example.messagepatterns.message;

public record GetInventoryAvailability(
        String productName,
        int requestedQuantity
) {
}