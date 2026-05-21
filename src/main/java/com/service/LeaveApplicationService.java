package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.LeaveApplication;
import com.repository.LeaveApplicationRepository;

@Service
public class LeaveApplicationService {
	@Autowired
	LeaveApplicationRepository repository;
	
	//apply for leave 
	public String applyforleave(LeaveApplication l)
	{
		l.setStatus("pending");
		repository.save(l);
		return "Applide for leave succefully";
	}
	
	//find all leave details
	public List<LeaveApplication> findallleave()
	{
		return repository.findAll();
	}
	
	//cancle leave
	public String cancleleave(int leaveid)
	{
		LeaveApplication exist=repository.findById(leaveid).orElse(null);
		
		if(exist!=null)
		{
			repository.deleteById(leaveid);
			return "Leave cancle succfully";
		}
		else
		{
			return "no match recorde for given leaveid";
		}
	}
	
	//update leave
	public String updateleaveapplication(int leaveid, LeaveApplication leave)
	{
		LeaveApplication exist=repository.findById(leaveid).orElse(null);
		if(exist ==null)
		{
			return "no recorde for give leaveid";
			
		}
		if(leave.getReason()==null && leave.getTodate()==null && leave.getFromdate()==null)
		{
			return "No new data found";
		}
		else {
			if(leave.getFromdate()!=null)
			{
				exist.setFromdate(leave.getFromdate());
			}
			if(leave.getTodate()!=null)
			{
				exist.setTodate(leave.getTodate());
			}
			if(leave.getReason()!=null)
			{
				exist.setReason(leave.getReason());
			}
			repository.save(exist);
			return "Leave Update Succefully";
		}
		
	}
	
	//
	public String updateleavestatus(int leaveid ,String action)
	{
		LeaveApplication exist=repository.findById(leaveid).orElse(null);
		
		if(exist!=null)
		{
			exist.setStatus(action);
			repository.save(exist);
			return "Leave status update succefully";
		}
		else
		{
			return "No matching recorde for give leaveid";
		}
	}
	
	public List<LeaveApplication> findleavebyempid(int empid)
	{
		return repository.findleavebyempid(empid);
	}

}
