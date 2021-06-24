package com.eretail.sale.services;

import com.eretail.sale.entites.Product;
import com.eretail.sale.entites.ProductClient;
import com.eretail.sale.feignclients.ProductFeignClient;
import com.eretail.sale.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductFeignClient productFeignClient;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product saveProductService(Long id) {
        ProductClient objClient = this.productFeignClient.getProductsById(id).getBody();
        Product obj = new Product();
        obj.setName(objClient.getProduct());
        obj.setPrice(objClient.getPrice());
        obj = this.save(obj);
        return obj;
    }

}
