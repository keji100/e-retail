package com.eretail.sale.resources.request;

import java.util.Date;
import java.util.List;

public class SaleRequest {

    private SalespersonSaleRequest salesperson;
    private CostumerSaleRequest costumer;
    private List<ProductSaleRequest> products;
    private Date date;

    public void setCostumer(CostumerSaleRequest costumer) {
        this.costumer = costumer;
    }

    public CostumerSaleRequest getCostumer() {
        return costumer;
    }
    
    public void setProducts(List<ProductSaleRequest> products) {
        this.products = products;
    }

    public List<ProductSaleRequest> getProducts() {
        return products;
    }

    public void setSalesperson(SalespersonSaleRequest salesperson) {
        this.salesperson = salesperson;
    }

    public SalespersonSaleRequest getSalesperson() {
        return salesperson;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
