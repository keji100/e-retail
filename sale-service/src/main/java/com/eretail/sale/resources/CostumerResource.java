package com.eretail.sale.resources;

import com.eretail.sale.entites.Costumer;
import com.eretail.sale.resources.request.CostumerRequest;
import com.eretail.sale.resources.response.CustomerResponse;
import com.eretail.sale.services.CostumerService;
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
@RequestMapping(value = "/customer")
public class CostumerResource implements Serializable {

    private final CostumerService service;
    private final ObjectMapper objectMapper;

    public CostumerResource(CostumerService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable UUID id) {
        Optional<Costumer> costumer = this.service.findById(id);
        if(costumer.isPresent()) {
            return ResponseEntity.ok(objectMapper.convertValue(costumer, CustomerResponse.class));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<CustomerResponse>> findAll() {
        List<Costumer> costumers = this.service.findAll();
        return ResponseEntity.ok(costumers
                        .stream()
                        .map(costumer -> objectMapper.convertValue(costumer, CustomerResponse.class))
                        .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Costumer> save(@RequestBody CostumerRequest costumerRequest) {
        Costumer costumer = objectMapper.convertValue(costumerRequest, Costumer.class);
        Costumer costumerResponse = service.save(costumer);
        return ResponseEntity.ok(costumerResponse);
    }

}
