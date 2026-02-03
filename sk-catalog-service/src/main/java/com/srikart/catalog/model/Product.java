package com.srikart.catalog.model;

import java.math.BigDecimal;

public class Product {
  private String id;
  private String brand;
  private String model;
  private ProductType type;
  private BigDecimal price;
  private String imageUrl;

  public Product() {}

  public Product(String id, String brand, String model, ProductType type, BigDecimal price, String imageUrl) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.type = type;
    this.price = price;
    this.imageUrl = imageUrl;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getBrand() { return brand; }
  public void setBrand(String brand) { this.brand = brand; }

  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }

  public ProductType getType() { return type; }
  public void setType(ProductType type) { this.type = type; }

  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }

  public String getImageUrl() { return imageUrl; }
  public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}

