package com.sprink.api.sprinkorderservice.exception;

public class OrderNotFoundException extends Exception{
	OrderNotFoundException()
	{
		
	}
	
	public OrderNotFoundException(String message)
	{
		 super(message);
	}
	OrderNotFoundException(String message, Throwable cause)
	{
		 super(message, cause);
	}
}
