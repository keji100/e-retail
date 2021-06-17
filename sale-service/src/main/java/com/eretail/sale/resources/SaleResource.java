package com.eretail.sale.resources;

import com.eretail.sale.entites.Sale;
import com.eretail.sale.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource implements Serializable {

    @Autowired
    private SaleService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id) {
        Sale obj = this.service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Sale>> findAll() {
        List<Sale> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }

}
