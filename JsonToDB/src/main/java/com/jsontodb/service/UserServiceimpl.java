package com.jsontodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.jsontodb.entity.Users;

import com.jsontodb.repo.UserRepository;

@Service
public class UserServiceimpl implements UserService {
	
	@Autowired
    public UserRepository repo;


     
  

	



	@Override
	public List<Users> findAll() {
		
		return  repo.findAll();
	}


	@Override
	public Users save(Users user) {
		
		return repo.save(user);
		
	}
	@Override
	public Users findById(int id) {
	   Optional<Users> user=repo.findById(id);
	   if(user==null) {
		   throw new RuntimeException("user id not found"+id);
	   }
	   return user.get();
	}
	
	@Override
	public  String delete(int id) {
		
		Optional<Users> user=repo.findById(id);
		if(user==null) {
			throw new RuntimeException("user id not found"+id);
			
		}
		repo.deleteById(id);
		return "User Deleted with id"+id;
		
	}
	@Override
	public void saveAll(List<Users> users) {
		repo.saveAll(users);
	}
}
