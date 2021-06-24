package com.eretail.sale.services;

import com.eretail.sale.entites.Costumer;
import com.eretail.sale.repositories.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CostumerService {

    private CostumerRepository repository;

    public CostumerService(CostumerRepository repository) {
        this.repository = repository;
    }

    public Optional<Costumer> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Costumer> findAll() {
        return repository.findAll();
    }

    public Costumer save(Costumer costumer) {
        return repository.save(costumer);
    }

}
