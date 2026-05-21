package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	//derived methods for searching operation
	
	//search firstname
	public List<Employee> findByFirstname(String firstname);
	
	//last name
	public List<Employee> findByLastname(String lastname);
	
	//department
	public List<Employee> findByDepartment(String department);
	
	//designation
	public List<Employee> findByDesignation(String designation);

}
