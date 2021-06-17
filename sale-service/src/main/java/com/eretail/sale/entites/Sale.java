package com.eretail.sale.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;
    private String nameSaleperson;
    private Date dateSale;
    private BigDecimal total;

    public Sale(String nameClient, String nameSaleperson, Date dateSale, BigDecimal total) {
        this.nameClient = nameClient;
        this.nameSaleperson = nameSaleperson;
        this.dateSale = dateSale;
        this.total = total;
    }

}
