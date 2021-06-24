package com.eretail.sale.resources.response;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;

@Builder
public class ProductResponse {

    private UUID id;
    private String name;
    private BigDecimal price;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
