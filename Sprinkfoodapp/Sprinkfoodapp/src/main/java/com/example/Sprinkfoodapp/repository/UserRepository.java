package com.example.Sprinkfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Sprinkfoodapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select *from user u where u.email=?1",nativeQuery = true)
	User findByEmail(String email);
	@Query(value = "select *from user u where u.email=?1",nativeQuery = true)
	User findByEmailAndPassword(String email,String password);
	
	
	
}
