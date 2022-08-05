package com.artplancom2.DTO.AnimalType;

import com.artplancom2.Interface.ValidatedDTO;

public class AnimalTypeEditDTO implements ValidatedDTO {

	private int animalTypeId;
	private String name;

	public int getAnimalTypeId() {
		return animalTypeId;
	}
	public void setAnimalTypeId(int animalTypeId) {
		this.animalTypeId = animalTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean isValid() {
		return animalTypeId != 0 && name != null;
	}
	
}
