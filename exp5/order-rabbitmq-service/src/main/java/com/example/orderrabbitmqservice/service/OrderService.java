package com.example.orderrabbitmqservice.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.orderrabbitmqservice.config.RabbitMQConfig;
import com.example.orderrabbitmqservice.entity.Order;
import com.example.orderrabbitmqservice.event.OrderCreatedEvent;
import com.example.orderrabbitmqservice.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;

    public OrderService(OrderRepository orderRepository,
                        RabbitTemplate rabbitTemplate) {
        this.orderRepository = orderRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Order createOrder(Order order) {

        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        if (order.getAmount() <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero"
            );
        }

        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
                UUID.randomUUID(),
                UUID.randomUUID(),
                savedOrder.getId(),
                savedOrder.getCustomerId(),
                savedOrder.getAmount(),
                LocalDateTime.now()
        );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                event
        );

        return savedOrder;
    }
}