package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.UserDTO;
import com.entity.User;
import com.service.UserService;

@RestController
@CrossOrigin
public class UserController
{

	@Autowired
	UserService service;
	
	//registration user
	@PostMapping("/regist")
	public String userresister(@RequestBody User user)
	{
		return service.regidtrstion(user);
	}
	
	//login
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO dto)
	{
		User exist=service.login(dto);
		if(exist!=null)
		{
			return ResponseEntity.ok(exist);
		}
		else
		{
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Invalid Username And Password");
		}
	}
}
