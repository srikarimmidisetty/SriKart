package com.srikart.ui.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "srikart")
public class SriKartProps {
  private String catalogBaseUrl;
  private String orderBaseUrl;

  public String getCatalogBaseUrl() { return catalogBaseUrl; }
  public void setCatalogBaseUrl(String catalogBaseUrl) { this.catalogBaseUrl = catalogBaseUrl; }

  public String getOrderBaseUrl() { return orderBaseUrl; }
  public void setOrderBaseUrl(String orderBaseUrl) { this.orderBaseUrl = orderBaseUrl; }
}
