package com.eretail.sale.services;

import com.eretail.sale.entites.Sale;
import com.eretail.sale.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SaleService {

    private SaleRepository repository;

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public Optional<Sale> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Sale> findAll() {
        return repository.findAll();
    }

    public Sale save(Sale sale) {
        return repository.save(sale);
    }

}
