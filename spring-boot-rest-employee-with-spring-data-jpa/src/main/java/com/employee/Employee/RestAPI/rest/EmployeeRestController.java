package com.employee.Employee.RestAPI.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee.RestAPI.entity.Employee;
import com.employee.Employee.RestAPI.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	 
	 public EmployeeRestController(EmployeeService employeeService) {
		 this.employeeService=employeeService;
	 }
	 
	 @GetMapping("/employees")
	 public List<Employee> findAll(){
		 return employeeService.findAll();
	 }
	 
	 //add mapping for GET /employees/{employeeId}
	 
	 @GetMapping("/employees/{employeeId}")
	 public Employee getEmployee(@PathVariable int employeeId) {
		 Employee theEmployee=employeeService.findById(employeeId);
		 if(theEmployee==null) {
			 throw new RuntimeException("Employee id not found -"+employeeId);
		 }
		 return theEmployee;
	 }
	 
	 @PostMapping("/employees")
	 public Employee addEmployee(@RequestBody Employee theEmployee) {
		 theEmployee.setId(0);
		 Employee dbEmployee=employeeService.save(theEmployee);
		 return dbEmployee;
	 }
	 
	 @PutMapping("/employees")
	 public Employee updateEmployee(@RequestBody Employee theEmployee) {
		 Employee dbEmployee=employeeService.save(theEmployee);
		 return dbEmployee;
	 }
	 
	 @DeleteMapping("/employees/{employeeId}")
	 public void deleteEmployee(@PathVariable int employeeId) {
		 Employee tempEmployee=employeeService.findById(employeeId);
		 if(tempEmployee==null) {
			 throw new RuntimeException("Employee id not found- "+employeeId);
		 }
		 employeeService.deleteById(employeeId);
		 
	 }
}
