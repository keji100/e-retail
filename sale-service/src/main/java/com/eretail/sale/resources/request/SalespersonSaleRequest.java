package com.eretail.sale.resources.request;

import java.util.UUID;

public class SalespersonSaleRequest {

    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
