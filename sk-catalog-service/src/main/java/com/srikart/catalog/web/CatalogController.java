package com.srikart.catalog.web;

import com.srikart.catalog.model.Product;
import com.srikart.catalog.model.ProductType;
import com.srikart.catalog.repo.InMemoryCatalog;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

  private final InMemoryCatalog catalog;

  public CatalogController(InMemoryCatalog catalog) {
    this.catalog = catalog;
  }

  @GetMapping("/products")
  public List<Product> products(@RequestParam Optional<ProductType> type,
                                @RequestParam Optional<String> brand) {
    return catalog.findAll(type, brand);
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> product(@PathVariable String id) {
    return catalog.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/health")
  public String health() {
    return "OK";
  }
}

