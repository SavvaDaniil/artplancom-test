package com.artplancom2.DTO.User;

import com.artplancom2.Interface.ValidatedDTO;

public class UserIdDTO implements ValidatedDTO {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean isValid() {
		return id != 0;
	}
	
}