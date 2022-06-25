package iss.sa54.team7.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iss.sa54.team7.model.Course;
import iss.sa54.team7.model.User;
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.UserService;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private UserService uService;
    @Autowired
    private CourseService cService;    
    
    @GetMapping("/manageCourses")
    List<Course> courselist() {return cService.findAllCourses();}
    @PostMapping("/manageCourses")
    public ResponseEntity<Course> createCourse(@RequestBody Course newCourse)
    {  	try {
    	Course c = cService.createCourse
    			(new Course(newCourse.getCourseName(), 
    			newCourse.getCourseStartDate(), newCourse.getCourseEndDate(),
    			newCourse.getCourseUnit(),newCourse.getMaxSize(),newCourse.getLecturerid()));
    			return new ResponseEntity<>(c, HttpStatus.CREATED);
    			} catch (Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    			} }    	
    @GetMapping("/manageCourses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id) {
		Course cData = cService.findCourse(id);
		if (cData.getCourseid()>0) {
			return new ResponseEntity<>(cData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}    
    @PutMapping("/manageCourses/edit/{id}")
	public ResponseEntity<Course> editStudent(@PathVariable("id") int id, @RequestBody Course course) {
		Course cData = cService.findCourse(id);
		if (cData.getCourseid()>0) {
			/*
			 * Course _course = cData.get(); _course.setCourseName(course.getCourseName());
			 * _course.setCourseStartDate(course.getCourseStartDate());
			 * _course.setCourseEndDate(course.getCourseEndDate());
			 * _course.setCourseUnit(course.getCourseUnit());
			 * _course.setMaxSize(course.getMaxSize());
			 * _course.setLecturerid(course.getLecturerid());
			 */
			return new ResponseEntity<>(cService.editCourse(course), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @DeleteMapping("/manageCourses")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") int id) {
		try {
			cService.removeCoursebyId(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}}

    @GetMapping("/manageUsers")
    List<User> userlist() {return uService.findAllUsers();}
    @PostMapping("/manageUsers")
    public ResponseEntity<User> createUser(@RequestBody User newUser)
    {  	try {
    	User u = uService.createUser
    			(new User(newUser.getUsername(), 
    			newUser.getPassword(), newUser.getName(),
    			newUser.getRole()));
    			return new ResponseEntity<>(u, HttpStatus.CREATED);
    			} catch (Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    			} }
    

}
