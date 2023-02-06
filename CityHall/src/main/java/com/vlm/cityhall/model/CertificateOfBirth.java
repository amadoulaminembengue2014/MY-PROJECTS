package com.vlm.cityhall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.vlm.cityhall.ENTITY.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CertificateOfBirth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private int registerNumber;
    private int number_of_prints;
    
    @OneToOne
    @JoinColumn(name = "person_id")
    private User user;

	public CertificateOfBirth() {
	}

	public CertificateOfBirth(Long id, int registerNumber, int number_of_prints, User user) {
		this.id = id;
		this.registerNumber = registerNumber;
		this.number_of_prints = number_of_prints;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getNumber_of_prints() {
		return number_of_prints;
	}

	public void setNumber_of_prints(int number_of_prints) {
		this.number_of_prints = number_of_prints;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
