package com.eretail.sale.resources.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public class SalespersonResponse {

    private UUID id;
    private String name;

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

}
