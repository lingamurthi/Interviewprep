package com.example.Sprinkfoodapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sprinkfoodapp.dto.BaseRequest;
import com.example.Sprinkfoodapp.exception.ApplicationException;
import com.example.Sprinkfoodapp.model.EmailDetails;
import com.example.Sprinkfoodapp.model.ResponseMessage;
import com.example.Sprinkfoodapp.model.User;
import com.example.Sprinkfoodapp.service.EmailService;
import com.example.Sprinkfoodapp.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public EmailService emailService;

	
	 @PostMapping("/sendMail")
	    public String
	    sendMail(@RequestBody EmailDetails details)
	    {
	        String status
	            = emailService.sendSimpleMail(details);
	 
	        return status;
	    }
	 
	 
	 @PostMapping("/sendMailWithAttachment")
	    public String sendMailWithAttachment(
	        @RequestBody EmailDetails details)
	    {
	        String status
	            = emailService.sendMailWithAttachment(details);
	 
	        return status;
	    }
	
	
	
	
	
	
	@PostMapping("/signup")
	public ResponseMessage createUser(@RequestBody @Valid User u1, BindingResult bindingResult)
			throws ApplicationException {

		if (bindingResult.hasErrors()) {
			// throw validation exception
			ResponseMessage response = new ResponseMessage();
			response.setStatus("Failure");
			StringBuilder errorMsg = new StringBuilder();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errorMsg.append(error.getDefaultMessage());
				errorMsg.append(" ");
			}
			response.setMessage("Validation Error: " + errorMsg);
			return response;
		} else {
			ResponseMessage response = new ResponseMessage();
			userService.create(u1);
			response.setStatus("Success");
			response.setMessage("Employee created Successfully");
			return response;
		}

	}

	
	  
	  @PostMapping("/signin") public String loadusername(@RequestBody BaseRequest user,HttpServletResponse response)throws Exception
	  {
	  
	  return userService.login(user.getEmail(),user.getPassword(),response);
	  
	  }
	  
	  
	  

	  
	  @PostMapping("/forgot") public String loaduseremail(@RequestBody BaseRequest user,HttpServletRequest request)throws Exception
	  {
	  
	 return emailService.forgot(user.getEmail(),request);
	  
	  }
	  
	  
	  
		/*
		 * @PostMapping("/reset") public void resetPassword(@RequestBody BaseRequest
		 * user)throws Exception {
		 * 
		 * emailService.reset(user.getPassword());
		 * 
		 * }
		 */

}
