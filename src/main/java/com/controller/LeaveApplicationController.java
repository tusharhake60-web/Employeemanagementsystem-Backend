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

import com.entity.LeaveApplication;
import com.service.LeaveApplicationService;

@RestController
@CrossOrigin
public class LeaveApplicationController {
	
	@Autowired
	LeaveApplicationService service;
	
	@PostMapping("/applyforleave")
	public String applyforleave(@RequestBody LeaveApplication l)
	{
		return service.applyforleave(l);
	}
	
	@GetMapping("/allleaves")
	public List<LeaveApplication> findallleave()
	{
		return service.findallleave();
	}
	
	@DeleteMapping("/cancleleave")
	public String cancleleave(@RequestParam int leaveid)
	{
		return service.cancleleave(leaveid);
	}
	
	@PutMapping("/updateleave")
	public String updateleave(@RequestParam int leaveid, @RequestBody LeaveApplication l)
	{
		return service.updateleaveapplication(leaveid, l);
	}
	
	@PutMapping("/updateleavestatus")
	public String updateleavestatus(@RequestParam int leaveid, @RequestParam String action)
	{
		return service.updateleavestatus(leaveid, action);
	}
	
	@GetMapping("/viewleavedetailebyemp")
	public List<LeaveApplication> findleavebyempid(@RequestParam int empid)
	{
		return service.findleavebyempid(empid);
	}

}
