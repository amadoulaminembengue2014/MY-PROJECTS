package com.kangamit.gestionstockbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kangamit.gestionstockbackend.Entity.OrderLineItem;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

}
