package com.example.orderrabbitmqservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderrabbitmqservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}