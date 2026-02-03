package com.srikart.order.web;

import com.srikart.order.model.OrderEntity;
import com.srikart.order.repo.OrderRepository;
import com.srikart.order.web.dto.CreateOrderRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Validated
public class OrderController {

  private final OrderRepository repo;

  public OrderController(OrderRepository repo) {
    this.repo = repo;
  }

  @PostMapping
  public ResponseEntity<OrderEntity> create(@Valid @RequestBody CreateOrderRequest req) {
    OrderEntity e = new OrderEntity();
    e.setProductId(req.getProductId());
    e.setCustomerName(req.getCustomerName());
    return ResponseEntity.ok(repo.save(e));
  }

  @GetMapping
  public List<OrderEntity> list() {
    return repo.findAll();
  }

  @GetMapping("/health")
  public String health() {
    return "OK";
  }
}

