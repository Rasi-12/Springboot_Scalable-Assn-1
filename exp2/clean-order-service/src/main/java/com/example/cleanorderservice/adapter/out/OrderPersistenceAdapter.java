package com.example.cleanorderservice.adapter.out;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleanorderservice.application.port.out.OrderRepositoryPort;
import com.example.cleanorderservice.domain.Order;
import com.example.cleanorderservice.infrastructure.persistence.OrderJpaEntity;
import com.example.cleanorderservice.infrastructure.persistence.OrderJpaRepository;

@Component
public class OrderPersistenceAdapter implements OrderRepositoryPort {

    private final OrderJpaRepository orderJpaRepository;

    public OrderPersistenceAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order save(Order order) {

        OrderJpaEntity entity = new OrderJpaEntity(
                order.getId(),
                order.getCustomerName(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice()
        );

        OrderJpaEntity savedEntity = orderJpaRepository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public List<Order> findAll() {

        return orderJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> findById(Long id) {

        return orderJpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        orderJpaRepository.deleteById(id);
    }

    private Order toDomain(OrderJpaEntity entity) {

        return new Order(
                entity.getId(),
                entity.getCustomerName(),
                entity.getProductName(),
                entity.getQuantity(),
                entity.getPrice()
        );
    }
}