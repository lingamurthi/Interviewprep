package com.sprink.api.sprinkmenuservice.exception;

public class MenuItemNotFoundException extends Exception{

	MenuItemNotFoundException()
	{
		
	}
	
	public MenuItemNotFoundException(String message)
	{
		 super(message);
	}
	MenuItemNotFoundException(String message, Throwable cause)
	{
		 super(message, cause);
	}
}
