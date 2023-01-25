package com.jsontodb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsontodb.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
