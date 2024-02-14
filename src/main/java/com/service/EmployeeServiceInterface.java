package com.service;

import java.util.List;

import com.model.Employee;



public interface EmployeeServiceInterface {

	public Employee saveEmployee(Employee e);
	
	public List<Employee> saveAllEmployee(List<Employee>list);
	 
	public Employee getOneEmployee(int id);
	
	public List<Employee> getAllEmployee();
	
//	public Employee getAllEmployee();
	
	public Employee updateEmployee(Employee e);
	
	public Employee getByEmail(String email);
	
//	List<String> findEmployeeNames();

	List<String> getEmployeeNames();

	
}
