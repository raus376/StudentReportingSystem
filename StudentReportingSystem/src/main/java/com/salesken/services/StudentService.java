package com.salesken.services;

import java.util.List;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Student;

public interface StudentService {
	
	public Student registerStudent(Student student) throws StudentException;
	
	public double averagePercentage(Integer semester) throws StudentException;
	
	public double averageMarksInSubject(String subject,Integer semester) throws StudentException;
	
	public List<Student> topTwoStudent() throws StudentException;

}
