package com.springbootprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootprogramming.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
