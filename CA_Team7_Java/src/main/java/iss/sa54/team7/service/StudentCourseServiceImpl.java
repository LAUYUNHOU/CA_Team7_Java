package iss.sa54.team7.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import iss.sa54.team7.model.*;
import iss.sa54.team7.repo.CourseRepo;
import iss.sa54.team7.repo.StudentCourseRepo;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
	@Resource
	private StudentCourseRepo studentcourseRepo;

	/*@Override
	@Transactional
	public Student_Course getScByCourseAndStudentID(Integer courseID, Integer studentID){
		return studentcourseRepo.getStudentCourseByCourseAndStudentID(courseID, studentID);
	}*/
	
	@Override
	@Transactional
	public ArrayList<Student_Course> findCoursesByStudentID(Integer studentID) {
		return studentcourseRepo.findCoursesByStudentID(studentID);
	}
	/*@Override
	@Transactional
	public ArrayList<Student_Course> findAllStudentsByCourseID(Integer cID) {
		return studentcourseRepo.findAllStudentsByCourseID(cID);
	}*/
	/*@Override
	@Transactional
	public ArrayList<Student_Course> getAllStudentsGradesByCourseID(Integer courseID) {
		return studentcourseRepo.getAllGradesByCourseID(courseID);
	}*/

	@Override
	@Transactional 
	public ArrayList<Student_Course> findAllStudentCourses() {
	 	ArrayList<Student_Course>list = (ArrayList<Student_Course>) studentcourseRepo.findAll(); 
	 	return list; 
	}

	@Override
	@Transactional
	public Student_Course findStudentCourse(Integer courseID) {
		return studentcourseRepo.findById(courseID).orElse(null);
	}

	@Override
	@Transactional
	public Student_Course createCourse(Student_Course StudentCourse) {
		return studentcourseRepo.saveAndFlush(StudentCourse);
	}
	@Override
	 @Transactional 
	 public Student_Course editCourse(Student_Course StudentCourse)
		{ return studentcourseRepo.saveAndFlush(StudentCourse); }
	 


}
