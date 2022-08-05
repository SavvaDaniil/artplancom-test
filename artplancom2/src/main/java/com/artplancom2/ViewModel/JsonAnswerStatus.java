package com.artplancom2.ViewModel;

import com.artplancom2.ViewModel.AnimalType.AnimalTypeLiteViewModel;
import com.artplancom2.ViewModel.AnimalType.AnimalTypeLitesViewModel;
import com.artplancom2.ViewModel.Pet.PetLiteViewModel;
import com.artplancom2.ViewModel.Pet.PetLitesOfUserViewModel;
import com.artplancom2.ViewModel.User.UserProfileViewModel;

public class JsonAnswerStatus {

	private String status;
	private String errors;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	
	public JsonAnswerStatus(String status) {
		super();
		this.status = status;
	}
	public JsonAnswerStatus(String status, String errors) {
		super();
		this.status = status;
		this.errors = errors;
	}
	
	
	
	
	private UserProfileViewModel userProfileViewModel;
	public UserProfileViewModel getUserProfileViewModel() {
		return userProfileViewModel;
	}
	public void setUserProfileViewModel(UserProfileViewModel userProfileViewModel) {
		this.userProfileViewModel = userProfileViewModel;
	}
	public JsonAnswerStatus(String status, String errors, UserProfileViewModel userProfileViewModel) {
		super();
		this.status = status;
		this.errors = errors;
		this.userProfileViewModel = userProfileViewModel;
	}
	
	
	
	
	private AnimalTypeLiteViewModel animalTypeLiteViewModel;
	public AnimalTypeLiteViewModel getAnimalTypeLiteViewModel() {
		return animalTypeLiteViewModel;
	}
	public void setAnimalTypeLiteViewModel(AnimalTypeLiteViewModel animalTypeLiteViewModel) {
		this.animalTypeLiteViewModel = animalTypeLiteViewModel;
	}
	public JsonAnswerStatus(String status, String errors, AnimalTypeLiteViewModel animalTypeLiteViewModel) {
		super();
		this.status = status;
		this.errors = errors;
		this.animalTypeLiteViewModel = animalTypeLiteViewModel;
	}
	
	
	
	
	
	
	private PetLiteViewModel petLiteViewModel;
	public PetLiteViewModel getPetLiteViewModel() {
		return petLiteViewModel;
	}
	public void setPetLiteViewModel(PetLiteViewModel petLiteViewModel) {
		this.petLiteViewModel = petLiteViewModel;
	}
	public JsonAnswerStatus(String status, String errors, PetLiteViewModel petLiteViewModel) {
		super();
		this.status = status;
		this.errors = errors;
		this.petLiteViewModel = petLiteViewModel;
	}
	
	
	
	
	
	private PetLitesOfUserViewModel petLitesOfUserViewModel;
	public PetLitesOfUserViewModel getPetLitesOfUserViewModel() {
		return petLitesOfUserViewModel;
	}
	public void setPetLitesOfUserViewModel(PetLitesOfUserViewModel petLitesOfUserViewModel) {
		this.petLitesOfUserViewModel = petLitesOfUserViewModel;
	}
	public JsonAnswerStatus(String status, String errors, PetLitesOfUserViewModel petLitesOfUserViewModel) {
		super();
		this.status = status;
		this.errors = errors;
		this.petLitesOfUserViewModel = petLitesOfUserViewModel;
	}
	
	
	
	
	
	private AnimalTypeLitesViewModel animalTypeLitesViewModel;
	public AnimalTypeLitesViewModel getAnimalTypeLitesViewModel() {
		return animalTypeLitesViewModel;
	}
	public void setAnimalTypeLitesViewModel(AnimalTypeLitesViewModel animalTypeLitesViewModel) {
		this.animalTypeLitesViewModel = animalTypeLitesViewModel;
	}
	public JsonAnswerStatus(String status, String errors, AnimalTypeLitesViewModel animalTypeLitesViewModel) {
		super();
		this.status = status;
		this.errors = errors;
		this.animalTypeLitesViewModel = animalTypeLitesViewModel;
	}
	
	
}
