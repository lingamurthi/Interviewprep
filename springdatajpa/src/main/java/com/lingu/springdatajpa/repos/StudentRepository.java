package com.lingu.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingu.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
