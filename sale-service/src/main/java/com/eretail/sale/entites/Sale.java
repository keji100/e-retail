package com.eretail.sale.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name="SALE")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "costumer_id", referencedColumnName = "id")
    private Costumer costumer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "salesperson_id", referencedColumnName = "id")
    private Salesperson salesperson;

    @ManyToMany
    @JoinTable(
            name = "product_sale",
            joinColumns = @JoinColumn(name = "sale_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products;
    @Column
    private Date date;
    @Column
    private BigDecimal amount;

}
