package com.vlm.springboot.DTO;

import javax.persistence.Column;

public class AdminDTO {
	
    public String emailId;
    
    @Column(name="password")  
    public String password;  
      
    @Column(name="role")  
    public String role;  
      
    public AdminDTO() { }  
  
    public AdminDTO(String emailId, String password, String role) {  
        super();  
        
        this.emailId = emailId;    
        this.password = password;  
        this.role = role;
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

}
