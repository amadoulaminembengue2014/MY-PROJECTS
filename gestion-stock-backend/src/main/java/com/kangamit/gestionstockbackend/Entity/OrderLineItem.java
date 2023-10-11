package com.kangamit.gestionstockbackend.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kangamit.gestionstockbackend.Enum.OrderStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderLineItems")
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderLineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	private double price;
	private double total;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product product;
	
	@Enumerated(EnumType.ORDINAL)
	private OrderStatusEnum orderstatusenum;

}
