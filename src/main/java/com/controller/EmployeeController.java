package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Employee;
import com.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	//Add employee 
	@PostMapping("/addemp")
	public String addEmployee(@RequestBody Employee e)
	{
		return service.addemp(e);
	}
	
	//Get Employee List
	@GetMapping("/getemplist")
	public List<Employee> getemplist()
	{
		return service.findemplist();
	}
	
	//Get Employee By Id
	@GetMapping("/getempbyid")
	public Employee getemp(@RequestParam int empid)
	{
		return service.findempid(empid);
	}
	
	//Get Employee By First Name
	@GetMapping("/getempbyfname")
	public List<Employee> getempbyfname(@RequestParam String firstname)
	{
		return service.getEmpByFirstName(firstname);
	}
	
	//Get Employee by Last Name
	@GetMapping("/getempbylname")
	public List<Employee> getempbylname(@RequestParam String lastname)
	{
		return service.getEmpByLastName(lastname);
	}
	
	//Get Employee By designation
	@GetMapping("/getempbydesignation")
	public List<Employee> getempbydesignatio(@RequestParam String designation)
	{
		return service.getEmpByDesignation(designation);
	}
	
	//Get Employee by Department
	@GetMapping("/getempbydepartment")
	public List<Employee> getempbydepartment(@RequestParam String department)
	{
		return service.getEmpByDepartment(department);
	}
	
	//Delete Employee
	@DeleteMapping("/deleteemp")
	public String deleteemp(@RequestParam int empid)
	{
		return service.deleteid(empid);
	}
	
	//Update Employee 
	@PutMapping("/updateemp")
	public String updateemp(@RequestParam int empid,@RequestBody Employee e)
	{
		return service.updateemp(empid, e);
	}
	

}
