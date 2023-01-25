package com.lingu.springdatajpaone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingu.springdatajpaone.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
