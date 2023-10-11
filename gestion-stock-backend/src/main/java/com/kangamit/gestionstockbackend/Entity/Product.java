package com.kangamit.gestionstockbackend.Entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int code;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	@ManyToOne
	private Supplier supplier;
	
	@ManyToOne
	private Categorie categorie;
	
	@OneToMany(mappedBy = "product")
	private Collection<OrderLineItem> orderlineitems;

}
