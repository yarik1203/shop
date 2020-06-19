package com.example.magazyn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "productName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "id_category")
    Category category;

    @ManyToOne
    @JoinColumn(name = "id_discount")
    Discount discount;

    @ManyToOne
    @JoinColumn(name = "id_order")
    Order order;




}
