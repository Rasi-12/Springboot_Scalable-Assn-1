package com.example.cleanorderservice.application.port.out;

import java.util.List;
import java.util.Optional;

import com.example.cleanorderservice.domain.Order;

public interface OrderRepositoryPort {

    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(Long id);

    void deleteById(Long id);
}