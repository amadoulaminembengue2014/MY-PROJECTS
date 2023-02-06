package com.vlm.cityhall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.vlm.cityhall.ENTITY.User;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CertificateOfDeath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    
    private String cause_of_death;
    
    private LocalDate date_of_death;
    @OneToOne
    @JoinColumn(name = "person_id")
    private User user;
	public CertificateOfDeath() {
	}
	public CertificateOfDeath(Long id, String cause_of_death, LocalDate date_of_death, User user) {
		this.id = id;
		this.cause_of_death = cause_of_death;
		this.date_of_death = date_of_death;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCause_of_death() {
		return cause_of_death;
	}
	public void setCause_of_death(String cause_of_death) {
		this.cause_of_death = cause_of_death;
	}
	public LocalDate getDate_of_death() {
		return date_of_death;
	}
	public void setDate_of_death(LocalDate date_of_death) {
		this.date_of_death = date_of_death;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
    
}
