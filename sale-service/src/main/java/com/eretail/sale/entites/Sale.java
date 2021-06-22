package com.eretail.sale.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity(name="SALE")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String client;
    private String salesperson;
    private Date date;
    private BigDecimal amount;

    public Sale(String client, String salesperson, Date date, BigDecimal amount) {
        this.client = client;
        this.salesperson = salesperson;
        this.date = date;
        this.amount = amount;
    }

}
