package com.vlm.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="admin")  
public class Admin {
	
	

	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Long id; 
      
    @Column(name="email_id" , unique=true)  
    public String emailId;
      
    @Column(name="password")  
    public String password;  
      
    @Column(name="role")  
    public String role;  
      
    public Admin() { }  
  
    public Admin(Long id, String emailId, String password, String role, Object object, Object object2, Object object3) {  
        super();  
        this.id = id;
        this.emailId = emailId;    
        this.password = password;  
        this.role = role;  
    }  
  
   
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
  
    public String getEmailId() {  
        return emailId;  
    }  
  
    public void setEmailId(String emailId) {  
        this.emailId = emailId;  
    }  
  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public String getRole() {  
        return role;  
    }  
  
    public void setRole(String role) {  
        this.role = role;  
    }  
  
    @Override  
    public String toString() {  
        return "AdminDetail [Id=" + id + ", emailId=" + emailId + ", password=" + password  
                + ", role=" + role + "]";  
    }  

}
