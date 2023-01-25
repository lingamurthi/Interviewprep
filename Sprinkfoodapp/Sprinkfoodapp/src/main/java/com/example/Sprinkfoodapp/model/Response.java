package com.example.Sprinkfoodapp.model;

public class Response {
private String success;
private String error;


public Response()
{
	
}

public Response(String success, String error) {
	super();
	this.success = success;
	this.error = error;
}
public String getSuccess() {
	return success;
}
public String setSuccess(String success, String token) {
	return this.success = success;
}
public String getError() {
	return error;
}
public String setError(String error) {
	return this.error = error;
}


}
