package com.springbootprogramming.restapi.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprogramming.restapi.entity.Student;
import com.springbootprogramming.restapi.repository.StudentRepository;

@RestController
public class StudentController {
	

	@Autowired
	StudentRepository repo;
	// Get all the students which are there in my student table
	//localhost:8083/students
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> students = repo.findAll();
		return students;
	}
	
	// localhost:8083/students/123	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();		
		return student;	
	}
	
	// localhost:8083/students/add
	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {		
		repo.save(student);
	}
	
	// localhost:8083/students/add/123
	@PutMapping("/students/update/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)

	public Student updateStudent(@PathVariable int id, @RequestBody Student updateStudent) {
		Student student = repo.findById(id).get();
		if (updateStudent.getName() != null) {
            student.setName(updateStudent.getName());
        }
        if (updateStudent.getPercentage() != 0) {
            student.setPercentage(updateStudent.getPercentage());
        }
        if (updateStudent.getBranch() != null) {
            student.setBranch(updateStudent.getBranch());
        }

        repo.save(student);
        return student;
	}
	
	// localhost:8083/students/delete/123
	@DeleteMapping("/students/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student); 
	}	
}
