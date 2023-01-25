package com.lingu.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingu.springbootcrud.entity.Users;
import com.lingu.springbootcrud.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  
	@Autowired
	public UserRepository repo;
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
     @Override
	public void saveAll(List<Users> users) {
		// TODO Auto-generated method stub
        repo.saveAll(users);
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		Optional<Users> user=repo.findById(id);
		return user.get();
	}

	@Override
	public Users save(Users user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public String delete(int id) {
		
		Optional<Users> user=repo.findById(id);
		if(user==null)
		{
			throw new RuntimeException("user id not found"+id);
		}
		
		repo.deleteById(id);
		return "User deleted with id " +id;
	}
	

}
