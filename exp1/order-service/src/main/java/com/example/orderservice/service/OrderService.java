package com.example.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order updatedOrder) {

        Optional<Order> existingOrder = orderRepository.findById(id);

        if (existingOrder.isPresent()) {

            Order order = existingOrder.get();

            order.setCustomerName(updatedOrder.getCustomerName());
            order.setProductName(updatedOrder.getProductName());
            order.setQuantity(updatedOrder.getQuantity());
            order.setPrice(updatedOrder.getPrice());

            return orderRepository.save(order);
        }

        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}