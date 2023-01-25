package com.jsontodb.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsontodb.entity.Users;
import com.jsontodb.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	public UserService userService;
	

	
	@GetMapping("/users")
	public List<Users> findAll(){
		return userService.findAll();
	}
	@GetMapping("/user/{userid}")
	public Users getUser(@PathVariable int userid){
		
		Users user=userService.findById(userid);
		if(user==null) {
			throw new RuntimeException("user id not found"+userid);
		}
		
		return user;
	}
	  @PostMapping("/user")
      public Users addUser(@RequestBody Users user) {
		
		return userService.save(user);
		
	}
	@PutMapping("/update")
	public Users update(@RequestBody Users user) {
		
		return userService.save(user);
		
	}
	@DeleteMapping("/delete/{userid}")
	public String  delete(@PathVariable int  userid) {
		return userService.delete(userid);
	}

}
