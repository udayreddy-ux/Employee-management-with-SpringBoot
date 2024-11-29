package com.employee.Employee.RestAPI.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.Employee.RestAPI.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	
	//entitymanager
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
		List<Employee> res=new ArrayList<>();
		res.addAll(theQuery.getResultList());
		return res;
	}
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		// get employee
		Employee theemployee=entityManager.find(Employee.class,theId);
		
		//return employee
		return theemployee;
	}
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Employee theemployee=entityManager.merge(theEmployee);
		return theemployee;
	}
	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Employee theEmploye=entityManager.find(Employee.class,theId);
		entityManager.remove(theEmploye);
	}
	
	
}
