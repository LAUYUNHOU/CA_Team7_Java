package iss.sa54.team7.service;

import java.util.ArrayList;

import org.springframework.data.repository.query.Param;

import iss.sa54.team7.model.Student;

public interface StudentService {
	ArrayList<Student>findAllStudents();
	Student findStudent(Integer studentID);
	Student createStudent(Student student);
	Student editStudent(Student student);
	void removeStudent(Student student);
	public ArrayList<Student> findAllStudentsByCourse(Integer courseID);
	public String getGradeByStudentAndCourseID(Integer courseID, Integer studentID);
	void removeStudentbyId(Integer studentID);
	
}
