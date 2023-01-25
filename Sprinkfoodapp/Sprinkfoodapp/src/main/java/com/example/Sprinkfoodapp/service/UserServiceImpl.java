package com.example.Sprinkfoodapp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.example.Sprinkfoodapp.exception.ApplicationException;

import com.example.Sprinkfoodapp.model.ResponseMessage;
import com.example.Sprinkfoodapp.model.User;
import com.example.Sprinkfoodapp.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import com.example.Sprinkfoodapp.model.Response;

@Service
public class UserServiceImpl implements UserService {

	private String secret = "lingu";
	@Autowired
	private UserRepository repo;
	
	


	Map<String, Object> claims = new HashMap<>();

	@Override
	public void create(User u1) throws ApplicationException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		u1.setPassword(encoder.encode(u1.getPassword()));
		repo.save(u1);

	}

	@Override
	public String login(String email, String password,HttpServletResponse res)throws Exception{
		System.out.println("login method called");
		Response r=new Response();
		String token=new String();
		
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(16);

		System.out.println("Password: " + password);
		System.out.println("Email: " + email);
		User resposne = null;
		try {
			resposne = repo.findByEmailAndPassword(email, password);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean isPasswordMatches = bcrypt.matches(password, resposne.getPassword());
		System.out.println(isPasswordMatches);
		System.out.println(resposne);
		System.out.println(resposne.getPassword());

		System.out.println(email);

		/*
		 * if(resposne != null){ return
		 * Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new
		 * Date(System.currentTimeMillis())) .setExpiration(new
		 * Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
		 * .signWith(SignatureAlgorithm.HS256, secret).compact(); }
		 */

		if (resposne.getEmail().equals(email) && isPasswordMatches){


			token=Jwts.builder().setClaims(claims).setSubject(email)
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
					.signWith(SignatureAlgorithm.HS256, secret).compact();
			Cookie cookie = new Cookie("token", token);
			
			res.addCookie(cookie);
			return r.setSuccess("success",token);
					

		}
		else {
			
			return r.setError("error");
			
		}
		
		
		
	}

	
	
	
	
	
	
	
}
