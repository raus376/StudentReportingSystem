package com.salesken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesken.repository.StudentRepository;

@Controller
public class StudentControllerUI {
	
	@Autowired
	private StudentRepository sRepo;
	
	@GetMapping("/home")
	public String homeLauncher() {
		
		return "welcome";
	}
	

}
