package com.vlm.shop.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlm.shop.Entity.Bill;

public interface BillDao extends JpaRepository<Bill, Integer> {

}
