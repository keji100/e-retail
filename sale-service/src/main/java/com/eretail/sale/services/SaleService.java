package com.eretail.sale.services;

import com.eretail.sale.dto.SaleDTO;
import com.eretail.sale.entites.ProductClient;
import com.eretail.sale.entites.Sale;
import com.eretail.sale.feignclients.ProductFeignClient;
import com.eretail.sale.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    @Autowired
    private ProductFeignClient productFeignClient;

    public Sale findById(Long id) {
        Optional<Sale> obj = this.repository.findById(id);
        return obj.orElse(null);
    }

    public List<Sale> findAll() {
        List<Sale> list = this.repository.findAll();
        return list;
    }

    public Sale save(Sale obj) {
        return this.repository.save(obj);
    }

    public Sale fromDTO(SaleDTO dto){
        Sale obj = new Sale();
        obj.setClient(dto.getClient());
        obj.setSalesperson(dto.getSalesperson());
        return obj;
    }

    private boolean isProductsIdOK(SaleDTO dto){
        return dto.getProductsId() != null && !dto.getProductsId().isEmpty();
    }

    public Sale insertDTO(SaleDTO dto) {
        Sale obj = fromDTO(dto);
        if (isProductsIdOK(dto)){
            BigDecimal valor = new BigDecimal(0);
            for (Long idProduct: dto.getProductsId()) {
                ProductClient product = this.productFeignClient.getProductsById(idProduct).getBody();
                valor = valor.add(product.getPrice());
            }
            obj.setAmount(valor);
        }
        return this.save(obj);
    }

}
