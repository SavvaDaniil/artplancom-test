package com.artplancom2.ViewModel.AnimalType;

import java.util.ArrayList;

public class AnimalTypeLitesViewModel {
	
	private ArrayList<AnimalTypeLiteViewModel> animalTypeViewModels;

	public ArrayList<AnimalTypeLiteViewModel> getAnimalTypeViewModels() {
		return animalTypeViewModels;
	}
	public void setAnimalTypeViewModels(ArrayList<AnimalTypeLiteViewModel> animalTypeViewModels) {
		this.animalTypeViewModels = animalTypeViewModels;
	}

	public AnimalTypeLitesViewModel(ArrayList<AnimalTypeLiteViewModel> animalTypeViewModels) {
		super();
		this.animalTypeViewModels = animalTypeViewModels;
	}
	
}
