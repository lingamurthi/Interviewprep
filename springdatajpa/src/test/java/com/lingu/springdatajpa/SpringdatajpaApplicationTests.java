package com.lingu.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lingu.springdatajpa.entities.Student;
import com.lingu.springdatajpa.repos.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringdatajpaApplicationTests {
	
	@Autowired
	private StudentRepository repository;

	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("Lingu");
		student.setTestScore(100);
		repository.save(student);
		Student savedStudent = repository.findById(1l).get();
		
		assertNotNull(savedStudent);
				
	}

}
