package com.employee.Employee.RestAPI.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Employee.RestAPI.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
