package iss.sa54.team7.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa54.team7.model.Student;
import iss.sa54.team7.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentRepo srepo;

	@Override
	@Transactional
	public ArrayList<Student> findAllStudentsByCourse(Integer courseID){
		return srepo.findAllStudentsByCourseID(courseID);
		
	}

	@Override
	@Transactional
	public void removeStudent(Student student) {
		srepo.delete(student);
	}

	
	@Override	 
	@Transactional public ArrayList<Student> findAllStudents(){ 
		ArrayList<Student>list = (ArrayList<Student>) srepo.findAll();
		return list; 
	}
	 

	@Override
	@Transactional
	public Student createStudent(Student student) {
		return srepo.saveAndFlush(student);
	}

	@Override
	@Transactional
	public Student editStudent(Student student) {
		return srepo.saveAndFlush(student);
	}

	@Override
	@Transactional
	public Student findStudent(Integer studentID) {
		return srepo.findById(studentID).orElse(null);
	}

}
