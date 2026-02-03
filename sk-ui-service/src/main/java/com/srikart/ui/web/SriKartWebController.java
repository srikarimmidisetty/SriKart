package com.srikart.ui.web;

import com.srikart.ui.config.SriKartProps;
import com.srikart.ui.web.dto.Product;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class SriKartWebController {

  private final SriKartProps props;
  private final RestTemplate rt = new RestTemplate();

  public SriKartWebController(SriKartProps props) {
    this.props = props;
  }

  @GetMapping("/")
  public String home(Model model) {
    String url = props.getCatalogBaseUrl() + "/api/catalog/products";
    Product[] products = rt.getForObject(url, Product[].class);
    List<Product> list = products == null ? List.of() : Arrays.asList(products);
    model.addAttribute("products", list);
    return "index";
  }

  @PostMapping(value = "/buy", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String buy(@RequestParam String productId, @RequestParam String customerName, Model model) {
    String orderUrl = props.getOrderBaseUrl() + "/api/orders";
    String body = "{\"productId\":\"" + productId + "\",\"customerName\":\"" + customerName + "\"}";
    rt.postForObject(orderUrl, org.springframework.http.RequestEntity
        .post(java.net.URI.create(orderUrl))
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
        .body(body), String.class);

    return "redirect:/";
  }
}

