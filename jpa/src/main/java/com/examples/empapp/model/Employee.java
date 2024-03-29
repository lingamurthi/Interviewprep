package com.examples.empapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private int empId;
    @Column(name="name")
	private String name;
    @Column(name="age")
	private int age;
    @Column(name="department")
	private String department;
    @Column(name="designation")
	private String designation;
    @Column(name="country")
	private String country;
	
	public Employee()
	{
		
	}
	
	public Employee(int empId, String name, int age, String designation, String department, String country)
	{
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;		
		this.country = country;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return String.format("Id:%d, Name:%s", this.getEmpId(), this.getName());
	}


}
