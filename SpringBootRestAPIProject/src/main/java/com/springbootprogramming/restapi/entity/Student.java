package com.springbootprogramming.restapi.entity;

import java.util.regex.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student") // if you do not specify the name, it automatically takes the name of the class Student
public class Student {
	
	//private static final Pattern ALPHABETICAL_PATTERN = Pattern.compile("^[a-zA-Z]+$");
	private static final int MAX_NAME_BRANCH_LENGTH = 50; // name of the student should not exceed 50 characters
	private static final Pattern ALPHABETICAL_PATTERN = Pattern.compile("^[a-zA-Z]+$");
	
	@Id // this represents the primary key of the table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // to create the rollNo automatically 
	private int rollNo;
	// Try changing the column names here
	@Column
	private String name;
	@Column
	private float percentage;
	@Column
	private String branch;
	
	
	// default constructor
	public Student() {
		
	}
	
	

	/**
	 * @param name
	 * @param percentage
	 * @param branch
	 */
	public Student(String name, float percentage, String branch) {
		super();
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
	}

	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (!ALPHABETICAL_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("Name must contain only alphabetical characters");
        }
		if (name.length() > MAX_NAME_BRANCH_LENGTH) {
			throw new IllegalArgumentException("Name is too long, it should be below 50 characters");
		}
		
		this.name = name;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		//float percentage = student.getPercentage();
		if (percentage < 0.0 || percentage > 100.0) {
            throw new IllegalArgumentException("Percentage must be between 0.00 and 100.00");
        }
		this.percentage = percentage;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		if (branch.length() > MAX_NAME_BRANCH_LENGTH) {
            throw new IllegalArgumentException("Branch is too long");
        }
        if (!ALPHABETICAL_PATTERN.matcher(branch).matches()) {
            throw new IllegalArgumentException("Branch must contain only alphabetical characters");
        }
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
				+ "]";
	}
}
