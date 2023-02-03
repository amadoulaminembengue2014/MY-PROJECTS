<<<<<<< HEAD
package com.vlm.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlm.ps.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
=======
package com.vlm.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlm.ps.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
