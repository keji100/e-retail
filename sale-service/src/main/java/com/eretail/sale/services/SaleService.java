package com.eretail.sale.services;

import com.eretail.sale.entites.Sale;
import com.eretail.sale.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Sale findById(Long id) {
        Optional<Sale> obj = this.repository.findById(id);
        return obj.orElse(null);
    }

    public List<Sale> findAll() {
        List<Sale> list = this.repository.findAll();
        return list;
    }

}
