package com.artplancom2.ViewModel.Pet;

import java.util.ArrayList;

public class PetLitesOfUserViewModel {

	
	private ArrayList<PetLiteViewModel> petLiteViewModels;

	public ArrayList<PetLiteViewModel> getPetLiteViewModels() {
		return petLiteViewModels;
	}

	public void setPetLiteViewModels(ArrayList<PetLiteViewModel> petLiteViewModels) {
		this.petLiteViewModels = petLiteViewModels;
	}

	public PetLitesOfUserViewModel(ArrayList<PetLiteViewModel> petLiteViewModels) {
		super();
		this.petLiteViewModels = petLiteViewModels;
	}
	
}
