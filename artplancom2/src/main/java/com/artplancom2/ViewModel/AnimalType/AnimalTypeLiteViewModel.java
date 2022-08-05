package com.artplancom2.ViewModel.AnimalType;

public class AnimalTypeLiteViewModel {

	private int id;
	private String name;
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
	public AnimalTypeLiteViewModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
