package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByUsername(String username);
	//to chek username alredy registed or not 
	//login to check username valid or not
	
	public User findByEmpid(int empid);

}
