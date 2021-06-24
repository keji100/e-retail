package com.eretail.sale.resources;

import com.eretail.sale.entites.Salesperson;
import com.eretail.sale.resources.request.SalespersonRequest;
import com.eretail.sale.resources.response.SalespersonResponse;
import com.eretail.sale.services.SalespersonService;
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
@RequestMapping(value = "/salesperson")
public class SalespersonResource implements Serializable {

    private SalespersonService service;
    private ObjectMapper objectMapper;

    public SalespersonResource(SalespersonService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SalespersonResponse> findById(@PathVariable UUID id) {
        Optional<Salesperson> salesperson = this.service.findById(id);
        if (salesperson.isPresent()) {
            return ResponseEntity.ok(objectMapper.convertValue(salesperson, SalespersonResponse.class));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<SalespersonResponse>> findAll() {
        List<Salesperson> salesperson = this.service.findAll();
        return ResponseEntity.ok(salesperson
                .stream()
                .map(person -> objectMapper.convertValue(person, SalespersonResponse.class))
                .collect(Collectors.toList()));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Salesperson> save(@RequestBody SalespersonRequest salespersonRequest) {
        Salesperson salesperson = objectMapper.convertValue(salespersonRequest, Salesperson.class);
        Salesperson salespersonResponse = service.save(salesperson);
        return ResponseEntity.ok(salespersonResponse);
    }

}
