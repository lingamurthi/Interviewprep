package com.example.Sprinkfoodapp.dto;

public class ResetPassword {

	
	
	private String password;
	private String confirmpassword;
	
	
	
	
	public ResetPassword(String password, String confirmpassword) {
		super();
		this.password = password;
		this.confirmpassword = confirmpassword;
	}
	
	
	
	public ResetPassword()
	{
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	
}
