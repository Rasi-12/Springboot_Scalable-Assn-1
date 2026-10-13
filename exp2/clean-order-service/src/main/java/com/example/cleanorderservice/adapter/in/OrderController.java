package com.example.cleanorderservice.adapter.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleanorderservice.application.port.in.OrderUseCase;
import com.example.cleanorderservice.domain.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderUseCase orderUseCase;

    public OrderController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(
            @RequestBody Order order) {

        return ResponseEntity.ok(
                orderUseCase.createOrder(order)
        );
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {

        return ResponseEntity.ok(
                orderUseCase.getAllOrders()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                orderUseCase.getOrderById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long id,
            @RequestBody Order order) {

        return ResponseEntity.ok(
                orderUseCase.updateOrder(id, order)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(
            @PathVariable Long id) {

        orderUseCase.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }
}