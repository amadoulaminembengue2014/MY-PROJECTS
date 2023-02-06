package com.vlm.cityhall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vlm.cityhall.ENTITY.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name= "certificateofrole")
public class CertificateOfResidence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Long id;
	
	@Column(name= "Proof_Of_Residence")
	private String Proof_Of_Residence;
	
	@OneToOne()
	@JoinColumn(name= "user_id")
	private User user;

}
