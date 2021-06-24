package com.eretail.sale.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class ProductClient implements Serializable {

    private Long id;
    private BigDecimal price;
    private String product;
    private Long quantity;
    private Long id1;
    private Long id2;

}
