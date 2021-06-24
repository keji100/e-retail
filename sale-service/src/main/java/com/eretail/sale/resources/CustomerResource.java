package com.eretail.sale.resources;

import com.eretail.sale.entites.Customer;
import com.eretail.sale.resources.request.CustomerRequest;
import com.eretail.sale.resources.response.CustomerResponse;
import com.eretail.sale.services.CustomerService;
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
public class CustomerResource implements Serializable {

    private final CustomerService service;
    private final ObjectMapper objectMapper;

    public CustomerResource(CustomerService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable UUID id) {
        Optional<Customer> customer = this.service.findById(id);
        if(customer.isPresent()) {
            return ResponseEntity.ok(objectMapper.convertValue(customer, CustomerResponse.class));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<CustomerResponse>> findAll() {
        List<Customer> customers = this.service.findAll();
        return ResponseEntity.ok(customers
                        .stream()
                        .map(customer -> objectMapper.convertValue(customer, CustomerResponse.class))
                        .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerRequest customerRequest) {
        Customer customer = objectMapper.convertValue(customerRequest, Customer.class);
        Customer customerResponse = service.save(customer);
        return ResponseEntity.ok(customerResponse);
    }

}
