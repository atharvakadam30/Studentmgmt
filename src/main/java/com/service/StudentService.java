package com.service;

import com.dao.StudentDao;
import com.pojo.Student;

public class StudentService {
	StudentDao studentdao=new StudentDao();
	public void addstudent(Student s)
	{
		studentdao.addstudent(s);
	}
	public void deleteStudent(Student s) {
		studentdao.deleteStudent(s);
	}
	public void Updatestudent(Student s)
	{
		studentdao.Updatestudent(s);
	}
}
