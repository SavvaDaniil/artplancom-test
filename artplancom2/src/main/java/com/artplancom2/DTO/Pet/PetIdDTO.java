package com.artplancom2.DTO.Pet;

import com.artplancom2.Interface.ValidatedDTO;

public class PetIdDTO implements ValidatedDTO {

	private int petId;



	public int getPetId() {
		return petId;
	}



	public void setPetId(int petId) {
		this.petId = petId;
	}



	@Override
	public boolean isValid() {
		return petId != 0;
	}
	
}
