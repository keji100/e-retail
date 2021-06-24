package com.eretail.sale.repositories;

import com.eretail.sale.entites.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalespersonRepository extends JpaRepository<Salesperson, UUID> { }
