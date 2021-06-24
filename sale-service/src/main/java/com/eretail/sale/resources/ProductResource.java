package com.eretail.sale.resources;

import com.eretail.sale.entites.Product;
import com.eretail.sale.resources.request.ProductRequest;
import com.eretail.sale.resources.response.ProductResponse;
import com.eretail.sale.services.ProductService;
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
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductResource implements Serializable {

    private ProductService service;
    private final ObjectMapper objectMapper;

    public ProductResource(ProductService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable UUID id) {
        Optional<Product> product = this.service.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(ProductResponse.builder()
                    .id(product.get().getId())
                    .name(product.get().getName())
                    .price(product.get().getPrice())
                    .build());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<Product> products = this.service.findAll();
        return ResponseEntity.ok(products
                .stream()
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList()));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Product> save(@RequestBody ProductRequest productRequest) {
        Product product = objectMapper.convertValue(productRequest, Product.class);
        Product productResponse = service.save(product);
        return ResponseEntity.ok(productResponse);
    }

}
