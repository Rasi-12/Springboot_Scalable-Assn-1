package com.example.cleanorderservice.application.port.out;

import com.example.cleanorderservice.domain.Order;

public interface OrderMessagingPort {

    void publishOrderCreated(Order order);
}