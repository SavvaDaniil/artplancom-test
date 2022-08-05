package com.artplancom2.DTO.Pet;

import java.util.Date;

import com.artplancom2.Interface.ValidatedDTO;

public class PetNewDTO implements ValidatedDTO {

	private String name;
	private int sex;
	private Date datebirthday;
	private int animalTypeId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getDatebirthday() {
		return datebirthday;
	}
	public void setDatebirthday(Date datebirthday) {
		this.datebirthday = datebirthday;
	}
	public int getAnimalTypeId() {
		return animalTypeId;
	}
	public void setAnimalTypeId(int animalTypeId) {
		this.animalTypeId = animalTypeId;
	}
	
	@Override
	public boolean isValid() {
		return name != null && animalTypeId != 0;
	}
	
}
