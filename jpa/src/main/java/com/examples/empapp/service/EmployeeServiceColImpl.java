package com.examples.empapp.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.model.Employee;

public class EmployeeServiceColImpl implements EmployeeService{


	EmployeeDao dao=new EmployeeDao();
    @Override
	public void create(Employee emp) {
		dao.create(emp);
	}
    @Override
	public Employee get(int id){
		return dao.get(id);
}
    @Override
	public List<Employee> getAll() {
		return dao.getall();
		
}
    @Override
	public void update(int empId, Employee employee) {
		 dao.update(empId,employee);
		
}
    @Override
	public void delete(int empId) {
		dao.delete(empId);
	}
    @Override
	public boolean validate(Employee emp, String msg, Predicate<Employee> condition,
			Function<String, Boolean> operation) {
		if (!condition.test(emp)) {
			return operation.apply(msg);
		}
		return true;
	}

	// Get Employee count greater than given age
    @Override
	public long getEmployeeCountAgeGreaterThan(int age) {
	return dao.getEmployeeCountAgeGreaterThan(age);
	}

	// Get list of Employee IDs whose age is greater than given age
    @Override
	public List<Integer> getEmployeeIdsAgeGreaterThan(int age) {
		return dao.getEmployeeIdsAgeGreaterThan(age);
	}

	// Get Department wise Employee count
    @Override
	public Map<String, Long> getEmployeeCountByDepartment() {
	return dao.getEmployeeCountByDepartment();
	}

	// Get Department wise Employee count ordered by Department name
    @Override
	public Map<String, Long> getEmployeeCountByDepartmentOrdered() {
		return dao.getEmployeeCountByDepartmentOrdered();
	}
    @Override
	public synchronized void bulkImport() {
		dao.bulkImport();
	}
    @Override
	public void bulkExport() {
		dao.bulkExport();
	}



}
