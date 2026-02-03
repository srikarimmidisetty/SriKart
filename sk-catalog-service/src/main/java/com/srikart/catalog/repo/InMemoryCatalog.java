package com.srikart.catalog.repo;

import com.srikart.catalog.model.Product;
import com.srikart.catalog.model.ProductType;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class InMemoryCatalog {

  private final Map<String, Product> products = new LinkedHashMap<>();

  public InMemoryCatalog() {
    // Safe placeholder images (replace later with your own hosted images)
    add("car-bmw-m5", "BMW", "M5 Competition", ProductType.CAR, new BigDecimal("155000"),
        "https://placehold.co/600x360/png?text=BMW+M5");
    add("car-benz-s", "BENZ", "S-Class", ProductType.CAR, new BigDecimal("180000"),
        "https://placehold.co/600x360/png?text=BENZ+S-Class");
    add("car-audi-rs7", "AUDI", "RS7", ProductType.CAR, new BigDecimal("165000"),
        "https://placehold.co/600x360/png?text=AUDI+RS7");
    add("car-lambo-hur", "Lambo", "Huracan", ProductType.CAR, new BigDecimal("260000"),
        "https://placehold.co/600x360/png?text=Lambo+Huracan");
    add("car-bentley-gt", "Bentley", "Continental GT", ProductType.CAR, new BigDecimal("240000"),
        "https://placehold.co/600x360/png?text=Bentley+GT");

    add("bike-kawa-ninja", "Kawasaki", "Ninja ZX-10R", ProductType.BIKE, new BigDecimal("19000"),
        "https://placehold.co/600x360/png?text=Kawasaki+Ninja");
    add("bike-bmw-s1000rr", "BMW", "S1000RR", ProductType.BIKE, new BigDecimal("21000"),
        "https://placehold.co/600x360/png?text=BMW+S1000RR");
    add("bike-triumph-st", "Triumph", "Street Triple", ProductType.BIKE, new BigDecimal("14000"),
        "https://placehold.co/600x360/png?text=Triumph+Street+Triple");
  }

  private void add(String id, String brand, String model, ProductType type, BigDecimal price, String imageUrl) {
    products.put(id, new Product(id, brand, model, type, price, imageUrl));
  }

  public List<Product> findAll(Optional<ProductType> type, Optional<String> brand) {
    return products.values().stream()
        .filter(p -> type.map(t -> p.getType() == t).orElse(true))
        .filter(p -> brand.map(b -> p.getBrand().equalsIgnoreCase(b)).orElse(true))
        .collect(Collectors.toList());
  }

  public Optional<Product> findById(String id) {
    return Optional.ofNullable(products.get(id));
  }
}

