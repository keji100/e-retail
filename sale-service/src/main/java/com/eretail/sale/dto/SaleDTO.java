package com.eretail.sale.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaleDTO implements Serializable {

    private String client;
    private String salesperson;
    private BigDecimal amount;
    private List<Long> productsId;

}
