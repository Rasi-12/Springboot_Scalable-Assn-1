package com.example.ordereventservice.event;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/events")
public class OrderEventController {

    @PostMapping("/order-created")
    public OrderCreatedEvent createOrderCreatedEvent(
            @RequestBody CreateOrderEventRequest request) {

        return new OrderCreatedEvent(
                UUID.randomUUID(),
                UUID.randomUUID(),
                request.orderId(),
                request.customerId(),
                request.amount(),
                LocalDateTime.now()
        );
    }

    public record CreateOrderEventRequest(
            Long orderId,
            Long customerId,
            double amount
    ) {
    }
}