package com.salesken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Student;
import com.salesken.repository.StudentRepository;
import com.salesken.services.StudentService;

@Controller
public class StudentControllerUI {
	
	@Autowired
	private StudentRepository sRepo;
	
	@Autowired
	private StudentService sService;
	
	@GetMapping("/home")
	public String homeLauncher() {
		
		return "welcome";
	}
	
	
	
	
	

}
