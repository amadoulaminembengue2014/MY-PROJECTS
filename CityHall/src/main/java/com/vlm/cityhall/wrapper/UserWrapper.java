package com.vlm.cityhall.wrapper;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWrapper {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String birthDay;
	
	private String birthPlace;

	private String email;
	
	private String password;
	
	private String role;

	private String status;
	

}
