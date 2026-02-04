package com.srikart.order.web;

import com.srikart.order.model.OrderEntity;
import com.srikart.order.repo.OrderRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public OrderEntity createOrder(@Valid @RequestBody OrderEntity order) {
        return repo.save(order);
    }

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return repo.findAll();
    }
}

