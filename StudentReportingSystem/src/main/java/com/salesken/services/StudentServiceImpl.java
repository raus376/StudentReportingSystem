package com.salesken.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Student;
import com.salesken.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository sRepo;
	
	

	@Override
	public Student registerStudent(Student student) throws StudentException {
	  
		if(student!=null) {
			
			double avg=((double)student.getEnglishMarks()+(double)student.getMathMarks()+(double)student.getScienceMarks())/3;
			
			student.setAverageMarks(avg);
		
			return sRepo.save(student);
		}
		else 
			throw new StudentException("Fill all student Details");
		
	}

	@Override
	public double averagePercentage(Integer semester) throws StudentException {
		
		List<Student> list=sRepo.findBySemester(semester);
		
		double per=1;
		if(list.size()>0) {
			double sum=0;
			for(Student st:list) {
				
				sum+=((double)st.getEnglishMarks()+(double)st.getMathMarks()+(double)st.getScienceMarks())/300;
			}
			
			per=(sum/list.size())*100;
			
			return per;
		}
		else
			throw new StudentException("student not found In semester: "+semester);
	
	}

	@Override
	public double averageMarksInSubject(String subject,Integer semester) throws StudentException {
		
		List<Student> students=sRepo.findBySemester(semester);
		if(students.size()>0) {
			
		double ans=0;
		subject=subject.toLowerCase();
		if(subject.equals("english")) {
			double sum=0;
			for(Student st:students) {
				sum+=(double)(st.getEnglishMarks());
			}
			ans=sum/students.size();
			return ans;
//			List<Integer> list=sRepo.findByEnglishMarks(semester);
//			double sum=0;
//			for(Integer mark:list) {
//				sum+=(double)mark;
//			}
//			ans=sum/list.size();
//			
//			return ans;
		}
		else if(subject.equals("math")) {
			
			double sum=0;
			for(Student st:students) {
				sum+=(double)(st.getMathMarks());
			}
			ans=sum/students.size();
			return ans;
			
			
//			List<Integer> list=sRepo.findByMathMarks(semester);
//			double sum=0;
//			for(Integer mark:list) {
//				sum+=(double)mark;
//			}
//			ans=sum/list.size();
//			
//			return ans;
		}
       else if(subject.equals("science")) {
    	   
    	   double sum=0;
			for(Student st:students) {
				sum+=(double)(st.getScienceMarks());
			}
			ans=sum/students.size();
			return ans;
    	   
//    	   List<Integer> list=sRepo.findByScienceMarks(semester);
//			double sum=0;
//			for(Integer mark:list) {
//				sum+=(double)mark;
//			}
//			ans=sum/list.size();
//
//			return ans;
		}
       else {
    	   
       }
    	   throw new StudentException("subject not found with: "+subject);
	}
	else
		throw new StudentException("subject not found with: "+semester);
	}
	

	@Override
	public List<Student> topTwoStudent() throws StudentException {
		
		List<Student> ans=new ArrayList<>();
		
	            List<Student> list=sRepo.findAll();
	            
	            if(list.size()>0) {
	            	
	            	List<Student> st=list.stream().sorted(Comparator.comparing(Student::getAverageMarks)).collect(Collectors.toList());
	            	
	            	for(int i=st.size()-1;i>st.size()-3;i--) {
	            		ans.add(st.get(i));
	            	}
	            	
	            	return ans;
	            }
	            else
	            	throw new StudentException("student not found");
	}


}
