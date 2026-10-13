package com.example.cleanorderservice.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleanorderservice.application.port.in.OrderUseCase;
import com.example.cleanorderservice.application.port.out.OrderMessagingPort;
import com.example.cleanorderservice.application.port.out.OrderRepositoryPort;
import com.example.cleanorderservice.domain.Order;

@Service
public class OrderService implements OrderUseCase {

    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderMessagingPort orderMessagingPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort,
                        OrderMessagingPort orderMessagingPort) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.orderMessagingPort = orderMessagingPort;
    }

    @Override
    public Order createOrder(Order order) {

        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (order.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        Order savedOrder = orderRepositoryPort.save(order);

        orderMessagingPort.publishOrderCreated(savedOrder);

        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepositoryPort.findAll();
    }

    @Override
    public Order getOrderById(Long id) {

        return orderRepositoryPort.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id: " + id));
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {

        Order existingOrder = getOrderById(id);

        existingOrder.setCustomerName(updatedOrder.getCustomerName());
        existingOrder.setProductName(updatedOrder.getProductName());
        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setPrice(updatedOrder.getPrice());

        return orderRepositoryPort.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {

        getOrderById(id);

        orderRepositoryPort.deleteById(id);
    }
}