package iss.sa54.team7.service;

import java.util.ArrayList;

import iss.sa54.team7.model.Student;

public interface StudentService {
	public ArrayList<Student>findAllStudents();
	public Student findStudent(Integer studentID);
	public Student createStudent(Student student);
	public Student editStudent(Student student);
	public void removeStudent(Student student);
	//public String getGradeByStudentAndCourseID(Integer courseID, Integer studentID);
	public void removeStudentbyId(Integer studentID);
	
}
