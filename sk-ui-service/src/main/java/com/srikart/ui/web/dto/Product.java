package com.srikart.ui.web.dto;

import java.math.BigDecimal;

public class Product {
  private String id;
  private String brand;
  private String model;
  private String type;
  private BigDecimal price;
  private String imageUrl;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getBrand() { return brand; }
  public void setBrand(String brand) { this.brand = brand; }

  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }

  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }

  public String getImageUrl() { return imageUrl; }
  public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}

