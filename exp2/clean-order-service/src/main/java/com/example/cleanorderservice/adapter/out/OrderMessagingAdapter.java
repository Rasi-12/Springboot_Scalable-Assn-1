package com.example.cleanorderservice.adapter.out;

import org.springframework.stereotype.Component;

import com.example.cleanorderservice.application.port.out.OrderMessagingPort;
import com.example.cleanorderservice.domain.Order;

@Component
public class OrderMessagingAdapter implements OrderMessagingPort {

    @Override
    public void publishOrderCreated(Order order) {

        System.out.println(
                "MESSAGE EVENT: Order created - Order ID: "
                        + order.getId()
                        + ", Customer: "
                        + order.getCustomerName()
        );
    }
}