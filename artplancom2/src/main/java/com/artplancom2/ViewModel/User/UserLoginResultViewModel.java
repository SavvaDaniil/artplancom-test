package com.artplancom2.ViewModel.User;

public class UserLoginResultViewModel {

	private String status;
	private String errors;
	private String accessToken;
	
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
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public UserLoginResultViewModel(String status) {
		super();
		this.status = status;
	}
	public UserLoginResultViewModel(String status, String errors) {
		super();
		this.status = status;
		this.errors = errors;
	}
	public UserLoginResultViewModel(String status, String errors, String accessToken) {
		super();
		this.status = status;
		this.errors = errors;
		this.accessToken = accessToken;
	}
	
	
}
