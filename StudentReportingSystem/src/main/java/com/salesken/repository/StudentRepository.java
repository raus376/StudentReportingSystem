package com.salesken.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

 public List<Student> findBySemester(Integer semester);
 
 public List<Integer> findByEnglishMarks(Integer semester);
  
 public List<Integer> findByMathMarks(Integer semester);
 
 public List<Integer> findByScienceMarks(Integer semester);
 
 public Student findByRollNumber(Integer roll);
}
