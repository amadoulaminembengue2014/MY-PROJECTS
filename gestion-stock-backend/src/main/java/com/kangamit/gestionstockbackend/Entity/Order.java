package com.kangamit.gestionstockbackend.Entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kangamit.gestionstockbackend.Enum.OrderStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data @NoArgsConstructor @AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderNumber;
	private int quantity;
	private Date orderDate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Supplier supplier;
	
	@OneToMany(mappedBy = "order")
	private Collection<OrderLineItem> orderlineitems;
	
	@Enumerated(EnumType.ORDINAL)
	private OrderStatusEnum orderstatusenum;

}
