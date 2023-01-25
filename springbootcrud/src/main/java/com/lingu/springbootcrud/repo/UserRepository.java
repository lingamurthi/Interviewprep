package com.lingu.springbootcrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lingu.springbootcrud.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
