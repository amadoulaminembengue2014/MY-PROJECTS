package com.kangamit.gestionstockbackend.features.stock;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "stocks")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String code;
    private int quantity;
}
