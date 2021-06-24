package com.eretail.sale.feignclients;

import com.eretail.sale.entites.ProductClient;
import com.eretail.sale.entites.ProductListClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "products-service", url = "${feign.product.url}", path = "/products")
public interface ProductFeignClient {

    @GetMapping
    ResponseEntity<ProductListClient> findAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<ProductClient> getProductsById(@PathVariable Long id);

}
