package iss.sa54.team7.service;

import java.util.ArrayList;

import iss.sa54.team7.model.Student;

public interface StudentService {
	ArrayList<Student>findAllStudents();
	Student findStudent(Integer studentID);
	Student createStudent(Student student);
	Student editStudent(Student student);
	void removeStudent(Student student);
	
}
