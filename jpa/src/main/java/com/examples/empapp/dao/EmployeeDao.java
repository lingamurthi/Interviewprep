package com.examples.empapp.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;

import com.examples.empapp.model.Employee;

public class EmployeeDao {

	
	private static EntityManagerFactory factory;

	

		public void getConnection()
		{
			// STEP 1: Create EntityManagerFactory
			factory = Persistence.createEntityManagerFactory("com.examples.hibernate.jpa");
			System.out.println("Connected to databased - " + factory);

			// STEP 2: Create EntityManager
			// STEP 3: Transaction Management
			// STEP 4: Perform CRUD Operations using Query/Criteria API
		}

	

		

	

	// CREATE EMPLOYEE
	public Integer create(Employee employee) {
       getConnection();
		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Insert data into table by supplying the persistent object
			entityManager.persist(employee);

			System.out.println("\nEmployee inserted successfully with ID - " + employee.getEmpId());

			entityManager.getTransaction().commit();
		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}

		return employee.getEmpId();
	}

	// UPDATE EMPLOYEE DETAILS
	public void update(int empId, Employee employee) {
		 getConnection();
		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Update Employee Details
			Employee empForUpdate = entityManager.find(Employee.class, empId);
			empForUpdate.setDepartment(employee.getDepartment());
			empForUpdate.setDesignation(employee.getDesignation());
//			entityManager.persist();

			System.out.format("\nEmployee %s updated successfuly.\n", empId);

			entityManager.getTransaction().commit();

		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}
	}

	// DELETE EMPLOYEE DETAILS
	public void delete(Integer empId) {
		 getConnection();
		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Get Employee entity to delete
			Employee empForDelete = entityManager.find(Employee.class, empId);
			entityManager.remove(empForDelete);

			System.out.format("\nEmployee %s deleted successfuly.\n", empId);

			entityManager.getTransaction().commit();

		} catch (HibernateException he) {
			entityManager.getTransaction().rollback();
			he.printStackTrace();
		}
	}

	
	
	
	public Employee get(int id) {
		 getConnection();
		EntityManager entityManager = factory.createEntityManager();
		Employee employee=new Employee();
		try {
			entityManager.getTransaction().begin();

			// Insert data into table by supplying the persistent object
		 employee=entityManager.find(Employee.class,id);

			System.out.println("\nEmployee inserted successfully with ID - ");

			entityManager.getTransaction().commit();
		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}
		
		return employee;
	}
	
	
	
	
	
	public List<Employee> getall() {
		 getConnection();
		EntityManager entityManager = factory.createEntityManager();
		List<Employee> employees=null;
		try {
			entityManager.getTransaction().begin();

			// List Employee Details
			 employees = entityManager.createQuery("FROM Employee").getResultList();

			System.out.println("ID \tName \tAge \tDepartment \tDesignation \tCountry");
			for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();

				System.out.println(employee.getEmpId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t"
						+ "\t" + employee.getDepartment() + "\t" + employee.getDesignation() + "\t" + employee.getCountry());
			}

			entityManager.getTransaction().commit();

		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}
		return employees;
	}
	
	
	
	
	
	
	public long getEmployeeCountAgeGreaterThan(int age)
	{
		
	}
	
	public List<Integer> getEmployeeIdsAgeGreaterThan(int id)
	{
	
	}
	
	
	
	public Map<String, Long> getEmployeeCountByDepartment() {
		
		}
	
	
	public Map<String, Long> getEmployeeCountByDepartmentOrdered() {
		
	}
	
	
	public synchronized void bulkImport() {
		
	}
	
	
	public void bulkExport() {
		
	}
}
