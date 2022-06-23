package iss.sa54.team7.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import iss.sa54.team7.model.*;
import iss.sa54.team7.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {
	@Resource
	private CourseRepo courseRepo;

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByLectID(Integer lectID) {
		ArrayList<Course> list = findAllCourses();
		ArrayList<Course> list2 = new ArrayList<Course>();
		for (var Course : list) {
		    list2.add(Course);
		}
		return list2;
	}

	@Override
	@Transactional 
	public ArrayList<Course> findAllCourses() {
	 	ArrayList<Course>list = (ArrayList<Course>) courseRepo.findAll(); 
	 	return list; 
	}

	@Override
	@Transactional
	public Course findCourse(Integer courseID) {
		return courseRepo.findById(courseID).orElse(null);
	}

	@Override
	@Transactional
	public Course createCourse(Course course) {
		return courseRepo.saveAndFlush(course);
	}

	@Override
	@Transactional
	public Course editCourse(Course course) {
		return courseRepo.saveAndFlush(course);
	}

	@Override
	@Transactional
	public void removeCourse(Course course) {
		courseRepo.delete(course);
	}
	@Override
	@Transactional
	public void removeCoursebyId(Integer courseID){
		courseRepo.deleteById(courseID);
	};
	
}
