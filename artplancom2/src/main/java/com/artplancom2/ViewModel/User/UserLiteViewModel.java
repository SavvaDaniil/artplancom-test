package com.artplancom2.ViewModel.User;

public class UserLiteViewModel {

	private int id;
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserLiteViewModel(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
}
