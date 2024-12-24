package com.controller;

import com.pojo.Student;
import com.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		StudentService studentservice=new StudentService();
		Student s1=new Student(2, "Tka", 27, "Selenium") ;
		studentservice.addstudent(s1);
		
	}
}
