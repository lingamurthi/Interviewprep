package com.lingu.springbootcrud.service;

import java.util.List;



import com.lingu.springbootcrud.entity.Users;

public interface UserService {

	
	 public List<Users> findAll();
	   public void saveAll(List<Users> users);
	   public Users findById(int id);
		
		public  Users save(Users u);
		
		public String delete(int id);
}
