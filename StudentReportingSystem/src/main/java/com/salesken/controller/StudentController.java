package com.salesken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Student;
import com.salesken.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@PostMapping("/registerStudent")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) throws StudentException{
		
		Student stud=sService.registerStudent(student);
		
		return new ResponseEntity<>(stud,HttpStatus.ACCEPTED);
	  
	}
	
	@GetMapping("/getAveragePercentageOfWholeClass/{semester}")
	public double getAveragePercentageOfWholeClass(@PathVariable Integer semester) throws StudentException{
		
		double per=sService.averagePercentage(semester);
		
		return per;
	  
	}
	
	@GetMapping("/getAverageInSubject/{subject}/{semester}")
	public double getAverageInSubject(@PathVariable String subject,@PathVariable Integer semester) throws StudentException{
		
		double per=sService.averageMarksInSubject(subject, semester);
		
		return per;
	  
	}
	
	@GetMapping("/topTwoStudent")
	public ResponseEntity<List<Student>> topTwoStudent() throws StudentException{
		
		List<Student> ans=sService.topTwoStudent();
		
		return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
	  
	}
	
	
	

	

}
