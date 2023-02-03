<<<<<<< HEAD
package com.vlm.cityhall.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CityHallUtils {
	
	private CityHallUtils() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
		return new ResponseEntity<String>("{\"message\":\""+ responseMessage +"\"}", httpStatus);
	}

}
=======
package com.vlm.cityhall.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CityHallUtils {
	
	private CityHallUtils() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
		return new ResponseEntity<String>("{\"message\":\""+ responseMessage +"\"}", httpStatus);
	}

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
