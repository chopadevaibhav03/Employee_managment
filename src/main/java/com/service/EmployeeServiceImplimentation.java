package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eception.NoSearchException;
import com.model.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplimentation  implements EmployeeServiceInterface{
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee saveEmployee(Employee e) {
		empRepo.save(e);
		return e;
	}

	@Override
	public List<Employee> saveAllEmployee(List<Employee> list) {
		// TODO Auto-generated method stub
		return empRepo.saveAll(list);
		
	}
	
//	@Override
//	public Employee getOneEmployee(int id) {
//		// TODO Auto-generated method stub
//		return empRepo.findById(id).orElse(null);
//	}

	public Employee getOneEmployee(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).orElseThrow(()-> new NoSearchException("Employee not found exception"+id));
	}


	public List<Employee> getAllEmployee(){
		return empRepo.findAll();
	}

//	@Override
//	public Employee updateEmployee(Employee e) {
//		// TODO Auto-generated method stub
//		Employee existEmployee = empRepo.findById(e.getId()).orElse(null);
//		existEmployee.setFname(e.getFname());
//		return empRepo.save(existEmployee);
//	}
//	
	 @Override
	    public Employee updateEmployee(Employee e) {
	        Employee existEmployee = empRepo.findById(e.getId()).orElse(null);
	        if (existEmployee != null) {
	            existEmployee.setFirstName(e.getFirstName());
	            existEmployee.setLastName(e.getLastName()); // Set the last name
	            existEmployee.setEmail(e.getEmail()); // Optionally, update email as well
	            return empRepo.save(existEmployee);
	        } else {
	            // Handle the case when the employee with the given ID is not found
	            throw new NoSearchException("Employee not found with ID: " + e.getId());
	        }
	    }
	 
	
	
	public Employee getByEmail(String email) {
		
		return empRepo.findByEmail(email) ;
		
	}

	@Override
	public List<String> getEmployeeNames() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public 	List<String> getEmployeeNames(){
//			
//			return empRepo.findEmployeeNames();
//		}


	
	

	
}
