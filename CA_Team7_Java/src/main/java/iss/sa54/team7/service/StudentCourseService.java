package iss.sa54.team7.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import iss.sa54.team7.model.*;


public interface StudentCourseService {

	Student_Course findStudentCourse(Integer courseid);
	ArrayList<Student_Course>findAllStudentCourses();

	Student_Course createCourse(Student_Course StudentCourse);
	Student_Course editCourse(Student_Course StudentCourse);
	//ArrayList<Student_Course> getAllStudentsGradesByCourseID(Integer courseID);
	//public ArrayList<Student_Course> findAllStudentsByCourseID(Integer cID);
	//public ArrayList<Student_Course> findCoursesByStudentID(Integer studentID);
	//public Student_Course getScByCourseAndStudentID(Integer courseID, Integer studentID);
	//public void studentEnrollCourse(Integer courseId,Integer studentID);
    }
