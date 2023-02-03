<<<<<<< HEAD
package com.vlm.cityhall.wrapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
=======
package com.vlm.cityhall.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String birthDay;
	
	private String birthPlace;

	private String email;
	
	private String password;
	
	private String role;

	

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
