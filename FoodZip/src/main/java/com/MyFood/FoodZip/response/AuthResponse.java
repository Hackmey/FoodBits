package com.MyFood.FoodZip.response;


import com.MyFood.FoodZip.models.USER_ROLES;
import lombok.Data;

@Data
public class AuthResponse {
	
	private String message;
	private String jwt;
	private USER_ROLES role;
	


}
