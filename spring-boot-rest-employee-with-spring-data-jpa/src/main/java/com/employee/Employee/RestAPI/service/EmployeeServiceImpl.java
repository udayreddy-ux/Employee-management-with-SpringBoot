package com.employee.Employee.RestAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.employee.Employee.RestAPI.DAO.EmployeeRepository;
import com.employee.Employee.RestAPI.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
		employeeRepository=theemployeeRepository;
	}
	
	@Override
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result=employeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			//we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	//@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}

	@Override
	//@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
	}
	
}
