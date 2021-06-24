package com.eretail.sale.resources.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
public class SaleResponse {

    private SalespersonResponse salesperson;
    private CustomerResponse costumer;
    private List<ProductResponse> products;
    private Date date;
    private BigDecimal amount;

    public void setSalesperson(SalespersonResponse salesperson) {
        this.salesperson = salesperson;
    }

    public SalespersonResponse getSalesperson() {
        return salesperson;
    }

    public void setCostumer(CustomerResponse costumer) {
        this.costumer = costumer;
    }

    public CustomerResponse getCostumer() {
        return costumer;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

}
