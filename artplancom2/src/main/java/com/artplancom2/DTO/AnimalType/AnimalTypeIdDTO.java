package com.artplancom2.DTO.AnimalType;

import com.artplancom2.Interface.ValidatedDTO;

public class AnimalTypeIdDTO implements ValidatedDTO {

	private int animalTypeId;

	public int getAnimalTypeId() {
		return animalTypeId;
	}
	public void setAnimalTypeId(int animalTypeId) {
		this.animalTypeId = animalTypeId;
	}

	@Override
	public boolean isValid() {
		return animalTypeId != 0;
	}
	
}
