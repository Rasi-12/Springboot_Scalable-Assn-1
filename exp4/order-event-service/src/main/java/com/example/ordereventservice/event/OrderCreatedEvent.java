package com.example.ordereventservice.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID eventId,
        UUID correlationId,
        Long orderId,
        Long customerId,
        double amount,
        LocalDateTime timestamp
) {
}