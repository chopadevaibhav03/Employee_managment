package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeServiceInterface;
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/e")

public class EmployeeController {

	@Autowired
	EmployeeServiceInterface empService;
	
	@PostMapping("add")
	public Employee addEmployee(@RequestBody Employee e)
	{
		empService.saveEmployee(e);
		return e;
		
	}
	@PostMapping("addAll")
	public List<Employee> addAllEmployee(@RequestBody List<Employee> list) {
		// TODO Auto-generated method stub
		return empService.saveAllEmployee(list);
		
	}
	
	@GetMapping("/getOne/{id}")
	public Employee findOnegetOneEmployee(@PathVariable int id) 
		
		{
			Employee e = new Employee();
//		return empService.getOneEmployee(id);
			try {
				e = empService.getOneEmployee(id);
			} catch (Exception ex){
				System.out.println(ex);
				
			}
			
		return e;
	}
	
	@GetMapping("getAll")
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployee();
		
	}
	
	 @PutMapping("update/{id}")
	    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
	        updatedEmployee.setId(id);
	        return empService.updateEmployee(updatedEmployee);
	    }
	@GetMapping("getEmail/{email}")
	
	public Employee searchByEmail(@PathVariable String email) {
		return empService.getByEmail(email);
		
	}
	
//	@GetMapping("getNames")
//	public 	List<String> searchEmployeeNames(){
//		return empService.getEmployeeNames();
//		
//	}
	
	
	
}
