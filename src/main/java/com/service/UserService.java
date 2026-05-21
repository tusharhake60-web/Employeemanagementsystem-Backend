package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.UserDTO;
import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	//Registration user
	public String regidtrstion(User u)
	{
		User exist=repository.findByUsername(u.getUsername());
		User empid=repository.findByEmpid(u.getEmpid());
		
		if(empid!=null)
		{
			return "Alredy rejisted this employee";
		}
		else if(exist==null)
		{
			repository.save(u);
			return "User regidtration succefully";
		}
		else
		{
			return "Username alredy existed. use anothe username";
		}
	}
	
	//Login
	public User login(UserDTO dto)
	{
		User exist=repository.findByUsername(dto.getUsername());
		if(exist==null)
		{
			return null;
		}
		else
		{
			if(exist.getPassword().equals(dto.getPassword()))
			{
				return exist;
			}
			else
			{
				return null;
			}
		}
	}

}
