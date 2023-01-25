package com.example.Sprinkfoodapp.dto;

public class BaseRequest {

	private String email;
    private String password;
	public BaseRequest() {
		super();
	}

	

	public BaseRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
