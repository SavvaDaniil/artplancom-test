package com.artplancom2.DTO.User;

import com.artplancom2.Interface.ValidatedDTO;

public class UserRegistrationDTO implements ValidatedDTO {

	private String username;
	private String password;


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean isValid() {
		return username != null && password != null;
	}
	
	
}
