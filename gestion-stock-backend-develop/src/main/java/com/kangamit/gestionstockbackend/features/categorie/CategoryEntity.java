package com.kangamit.gestionstockbackend.features.categorie;

import com.kangamit.gestionstockbackend.features.product.ProductEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "categoryEntity", orphanRemoval = true)
    private Set<ProductEntity> productEntities = new LinkedHashSet<>();

}
