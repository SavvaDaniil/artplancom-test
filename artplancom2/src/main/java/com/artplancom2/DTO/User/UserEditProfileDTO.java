package com.artplancom2.DTO.User;

import com.artplancom2.Interface.ValidatedDTO;

public class UserEditProfileDTO implements ValidatedDTO {

	private String username;
	private String passwordNew;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	@Override
	public boolean isValid() {
		return username != null;
	}
	
	
}
