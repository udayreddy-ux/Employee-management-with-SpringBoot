package com.employee.Employee.RestAPI.DAO;

import java.util.List;

import com.employee.Employee.RestAPI.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
