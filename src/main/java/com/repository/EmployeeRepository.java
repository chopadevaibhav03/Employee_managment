package com.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


	Employee findByEmail(String email);
	
//	@Query("Select e.name from Employee e")
//	List<String> findEmployeeNames();

	
	
}
