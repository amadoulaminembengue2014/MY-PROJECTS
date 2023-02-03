<<<<<<< HEAD
package com.vlm.ps.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	private int orderId;
	private double amount;

}
=======
package com.vlm.ps.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	private int orderId;
	private double amount;

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
