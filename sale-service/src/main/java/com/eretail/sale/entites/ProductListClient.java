package com.eretail.sale.entites;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductListClient implements Serializable {
    private List<ProductClient> productClient;

    public ProductListClient() {
        this.productClient = new ArrayList<>();
    }
}
