package iss.sa54.team7.service;

import java.util.ArrayList;

import iss.sa54.team7.model.*;


public interface StudentCourseService {

	ArrayList<Student_Course>findAllStudentCourses();
	Student_Course findStudentCourse(Integer courseID);
	Student_Course createCourse(Student_Course StudentCourse);
	Student_Course editCourse(Student_Course StudentCourse);
	/*ArrayList<Student_Course> getAllStudentsGradesByCourseID(Integer courseID);
	public ArrayList<Student_Course> findAllStudentsByCourseID(Integer cID);
	public ArrayList<Student_Course> findCoursesByStudentID(Integer studentID);
	public Student_Course getScByCourseAndStudentID(Integer courseID, Integer studentID);*/
}
