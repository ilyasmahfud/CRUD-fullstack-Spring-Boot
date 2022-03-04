package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private Long productNumber;

    @Column(name = "nama")
    private String productName;


    @Column(name = "qty")
    private Integer productQty;
}

