package com.srikart.order.web.dto;

import javax.validation.constraints.NotBlank;

public class CreateOrderRequest {
  @NotBlank
  private String productId;

  @NotBlank
  private String customerName;

  public String getProductId() { return productId; }
  public void setProductId(String productId) { this.productId = productId; }

  public String getCustomerName() { return customerName; }
  public void setCustomerName(String customerName) { this.customerName = customerName; }
}

