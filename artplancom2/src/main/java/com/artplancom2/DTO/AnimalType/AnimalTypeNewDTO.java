package com.artplancom2.DTO.AnimalType;

import com.artplancom2.Interface.ValidatedDTO;

public class AnimalTypeNewDTO implements ValidatedDTO {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isValid() {
		return name != null;
	}
	
}
