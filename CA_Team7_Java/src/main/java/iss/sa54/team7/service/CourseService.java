package iss.sa54.team7.service;

import java.util.ArrayList;

import iss.sa54.team7.model.*;


public interface CourseService {

	ArrayList<Course>findAllCourses();
	Course findCourse(Integer courseID);
	Course createCourse(Course course);
	Course editCourse(Course course);
	void removeCourse(Course course);
	public ArrayList<Course> findCoursesByLectID(Integer lectID);
}
