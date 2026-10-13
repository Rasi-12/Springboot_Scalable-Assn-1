package com.example.cleanorderservice.application.port.in;

import java.util.List;

import com.example.cleanorderservice.domain.Order;

public interface OrderUseCase {

    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);
}