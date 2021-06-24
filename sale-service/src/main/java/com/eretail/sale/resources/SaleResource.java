package com.eretail.sale.resources;

import com.eretail.sale.entites.Product;
import com.eretail.sale.entites.Sale;
import com.eretail.sale.resources.request.SaleRequest;
import com.eretail.sale.resources.response.CustomerResponse;
import com.eretail.sale.resources.response.ProductResponse;
import com.eretail.sale.resources.response.SaleResponse;
import com.eretail.sale.resources.response.SalespersonResponse;
import com.eretail.sale.services.SaleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource implements Serializable {

    private SaleService service;
    private ObjectMapper objectMapper;

    public SaleResource(SaleService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleResponse> findById(@PathVariable UUID id) {
        Optional<Sale> sale = this.service.findById(id);
        if (sale.isPresent()) {
            return ResponseEntity.ok( SaleResponse.builder()
                    .salesperson(SalespersonResponse.builder()
                            .name(sale.get().getSalesperson().getName())
                            .build()
                    )
                    .customer(CustomerResponse.builder()
                            .name(sale.get().getCustomer().getName())
                            .email(sale.get().getCustomer().getEmail())
                            .build()
                    )
                    .products(sale.get().getProducts()
                            .stream()
                            .map(product -> ProductResponse.builder()
                                    .name(product.getName())
                                    .price(product.getPrice())
                                    .build())
                            .collect(Collectors.toList())
                    )
                    .amount(sale.get().getProducts()
                            .stream()
                            .map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
                    )
                    .build());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<SaleResponse>> findAll() {
        List<Sale> sales = this.service.findAll();
        return ResponseEntity.ok(sales
                .stream()
                .map(sale ->
                        SaleResponse.builder()
                                .salesperson(SalespersonResponse.builder()
                                        .name(sale.getSalesperson().getName())
                                        .build()
                                )
                                .customer(CustomerResponse.builder()
                                        .name(sale.getCustomer().getName())
                                        .email(sale.getCustomer().getEmail())
                                        .build()
                                )
                                .products(sale.getProducts()
                                        .stream()
                                        .map(product -> ProductResponse.builder()
                                                .name(product.getName())
                                                .price(product.getPrice())
                                                .build())
                                        .collect(Collectors.toList())
                                )
                                .amount(sale.getProducts()
                                        .stream()
                                        .map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
                                )
                                .build()
                ).collect(Collectors.toList()));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Sale> save(@RequestBody SaleRequest saleRequest) {
        Sale sale = objectMapper.convertValue(saleRequest, Sale.class);
        Sale saleResponse = service.save(sale);
        return ResponseEntity.ok(saleResponse);
    }

}
