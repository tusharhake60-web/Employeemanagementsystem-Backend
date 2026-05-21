package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	//Add single employee
	public String addemp(Employee e)
	{
		repository.save(e);
		return "Employee add succefull";
	}
	
	//Get Employee list
	public List<Employee> findemplist()
	{
		return repository.findAll();
	}

	//Get Employee By Id
	public Employee findempid(int eid)
	{
		return repository.findById(eid).orElse(null);
	}
	
	//Get Employee By First Name
	public List<Employee> getEmpByFirstName(String firstname)
	{
		return repository.findByFirstname(firstname);
	}
	
	//Get Employee By Last Name 
	public List<Employee> getEmpByLastName(String lastname)
	{
		return repository.findByLastname(lastname);
	}
	
	//Get Employee By Designation
	public List<Employee> getEmpByDesignation(String designation)
	{
		return repository.findByDesignation(designation);
	}
	
	//Get Employee By Department
	public List<Employee> getEmpByDepartment(String department)
	{
		return repository.findByDepartment(department);
	}
	
	//Delete Employee ById
	public String deleteid(int eid)
	{
		Employee existemp=repository.findById(eid).orElse(null);
		if(existemp!=null)
		{
			repository.deleteById(eid);
			return "Employee record delete succefully";
		}
		return "Employee Id not found";
	}
	
	//Update Employee By Id
	public String updateemp(int eid,Employee e)
	{
		Employee exist= repository.findById(eid).orElse(null);
		if(exist!=null)
		{
			if(e.getFirstname()==null && e.getMiddlename()==null && e.getLastname()==null && e.getEmail()==null && e.getDob()==null && e.getContactno()==0 
					&& e.getGender()==null && e.getEdu()==null && e.getAddress()==null && e.getAdharno()==0 && e.getPanno()==null && e.getProfile()==null && e.getDesignation()==null
					&& e.getDepartment()==null && e.getExp()==0 && e.getSalary()==0 && e.getWorklocation()==null && e.getReportingmanager()==null && e.getStatus()==null && e.getJoiningdate()==null)
			{
				return "New Recorde Not Found";
			}
			else
			{
				if(e.getFirstname()!=null)
				{
					exist.setFirstname(e.getFirstname());
				}
				if(e.getLastname()!=null)
				{
					exist.setLastname(e.getLastname());
				}
				if(e.getMiddlename()!=null)
				{
					exist.setMiddlename(e.getMiddlename());
				}
				if(e.getEmail()!=null)
				{
					exist.setEmail(e.getEmail());
				}
				if(e.getDob()!=null)
				{
					exist.setDob(e.getDob());
				}
				if(e.getContactno()!=0)
				{
					exist.setContactno(e.getContactno());
				}
				if(e.getGender()!=null)
				{
					exist.setGender(e.getGender());
				}
				if(e.getEdu()!=null)
				{
					exist.setEdu(e.getEdu());
				}
				if(e.getAdharno()!=0)
				{
					exist.setAdharno(e.getAdharno());
				}
				if(e.getAddress()!=null)
				{
					exist.setAddress(e.getAddress());
				}
				if(e.getPanno()!=null)
				{
					exist.setPanno(e.getPanno());
				}
				if(e.getProfile()!=null)
				{
					exist.setProfile(e.getProfile());
				}
				if(e.getDesignation()!=null)
				{
					exist.setDesignation(e.getDesignation());
				}
				if(e.getDepartment()!=null)
				{
					exist.setDepartment(e.getDepartment());
				}
				if(e.getExp()!=0)
				{
					exist.setExp(e.getExp());
				}
				if(e.getSalary()!=0)
				{
					exist.setSalary(e.getSalary());
				}
				if(e.getWorklocation()!=null)
				{
					exist.setWorklocation(e.getWorklocation());
				}
				if(e.getReportingmanager()!=null)
				{
					exist.setReportingmanager(e.getReportingmanager());
				}
				if(e.getStatus()!=null)
				{
					exist.setStatus(e.getStatus());
				}
				if(e.getJoiningdate()!=null)
				{
					exist.setJoiningdate(e.getJoiningdate());
				}
				
				repository.save(exist);
				return "Employee recorde update succefully";
			}
		}
		return "Employee id not found";
	}

}
