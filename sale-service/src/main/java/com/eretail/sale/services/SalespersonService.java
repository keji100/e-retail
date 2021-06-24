package com.eretail.sale.services;

import com.eretail.sale.entites.Salesperson;
import com.eretail.sale.repositories.SalespersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalespersonService {

    private SalespersonRepository repository;

    public SalespersonService(SalespersonRepository repository) {
        this.repository = repository;
    }

    public Optional<Salesperson> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Salesperson> findAll() {
        return repository.findAll();
    }

    public Salesperson save(Salesperson salesperson) {
        return repository.save(salesperson);
    }

}
