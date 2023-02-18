package com.salesken.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document(indexName = "product")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer studentId;
	
	private Integer rollNumber;
	
	private String name;
	
	private Integer semester;
	
	private Integer englishMarks;
	
	private Integer mathMarks;
	
	private Integer scienceMarks;
	
	private double averageMarks;
	
	private String address;

	
	
}
