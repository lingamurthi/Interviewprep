package com.example.Sprinkfoodapp.service;

import javax.servlet.http.HttpServletRequest;

import com.example.Sprinkfoodapp.dto.BaseRequest;
import com.example.Sprinkfoodapp.model.EmailDetails;
import com.example.Sprinkfoodapp.model.User;

public interface EmailService {

	
	
    String sendSimpleMail(EmailDetails details);
 
    String sendMailWithAttachment(EmailDetails details);
    
     String forgot(String email,HttpServletRequest request);
   // void reset(User u);
}
