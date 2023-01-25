package com.example.Sprinkfoodapp.service;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.Sprinkfoodapp.exception.ApplicationException;
import com.example.Sprinkfoodapp.model.User;






public interface UserService{

	public void create(User u1) throws ApplicationException;
	public String login(String email,String Password,HttpServletResponse response) throws ApplicationException, Exception;
	
}
