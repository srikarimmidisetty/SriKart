package com.srikart.order.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String productId;

  @Column(nullable = false)
  private String customerName;

  @Column(nullable = false)
  private Instant createdAt = Instant.now();

  public Long getId() { return id; }

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId; }

  public String getCustomerName() { return customerName; }
  public void setCustomerName(String customerName) { this.customerName = customerName; }

  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}

