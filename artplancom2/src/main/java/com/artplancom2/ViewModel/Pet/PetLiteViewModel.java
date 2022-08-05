package com.artplancom2.ViewModel.Pet;

import java.util.Date;

import com.artplancom2.ViewModel.AnimalType.AnimalTypeLiteViewModel;
import com.artplancom2.ViewModel.User.UserLiteViewModel;

public class PetLiteViewModel {

	private int id;
	private String name;
	private Date datebirthday;
	private UserLiteViewModel userLiteViewModel;
	private AnimalTypeLiteViewModel animalTypeLiteViewModel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDatebirthday() {
		return datebirthday;
	}
	public void setDatebirthday(Date datebirthday) {
		this.datebirthday = datebirthday;
	}
	public UserLiteViewModel getUserLiteViewModel() {
		return userLiteViewModel;
	}
	public void setUserLiteViewModel(UserLiteViewModel userLiteViewModel) {
		this.userLiteViewModel = userLiteViewModel;
	}
	public AnimalTypeLiteViewModel getAnimalTypeLiteViewModel() {
		return animalTypeLiteViewModel;
	}
	public void setAnimalTypeLiteViewModel(AnimalTypeLiteViewModel animalTypeLiteViewModel) {
		this.animalTypeLiteViewModel = animalTypeLiteViewModel;
	}
	public PetLiteViewModel(int id, String name, Date datebirthday) {
		super();
		this.id = id;
		this.name = name;
		this.datebirthday = datebirthday;
	}


	
	
}
