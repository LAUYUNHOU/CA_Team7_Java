package iss.sa54.team7.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iss.sa54.team7.model.Course;
import iss.sa54.team7.model.RoleType;
import iss.sa54.team7.model.Student;
import iss.sa54.team7.model.User;
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.StudentService;
import iss.sa54.team7.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private UserService uService;
    @Autowired
    private CourseService cService;    
    @Autowired
    private StudentService sService;
    
    @GetMapping("/manageCourses")
    List<Course> courselist() {return cService.findAllCourses();}    
    @RequestMapping("/manageCourses/create/{n}/{sd}/{ed}/{u}/{s}/{l}")
    public void createCourse(@PathVariable("n")String coursename,@PathVariable("sd") String courseStartDate,
    		@PathVariable("ed") String courseEndDate,@PathVariable("u")int units,
    		@PathVariable("s")int maxSize,@PathVariable("l")int lecturerid)
    {  	    	
    	DateTimeFormatter df = DateTimeFormatter
    			.ofPattern("yyyy-MM-dd");
    			LocalDate startDate = LocalDate
    			.parse(courseStartDate, df);
    			LocalDate endDate = LocalDate
    	    			.parse(courseEndDate, df);
    	Course c = new Course (coursename,startDate,endDate,(units),(maxSize),(lecturerid));
    	Course c1 = cService.createCourse(c);
    }
    
    @GetMapping("/manageCourses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id) {
		Course cData = cService.findCourse(id);
		if (cData.getCourseid()>0) {
			return new ResponseEntity<>(cData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}    
    @RequestMapping("/manageCourses/edit/{n}/{sd}/{ed}/{u}/{s}/{l}/{id}")
	public void editCourse(@PathVariable("n")String coursename,@PathVariable("sd") String courseStartDate,
    		@PathVariable("ed") String courseEndDate,@PathVariable("u")int units,
    		@PathVariable("s")int maxSize,@PathVariable("l")int lecturerid,@PathVariable("id")int courseid) {
		Course _course = cService.findCourse(courseid);
		DateTimeFormatter df = DateTimeFormatter
    			.ofPattern("yyyy-MM-dd");
    			LocalDate startDate = LocalDate
    			.parse(courseStartDate, df);
    			LocalDate endDate = LocalDate
    	    			.parse(courseEndDate, df);
		_course.setCourseName(coursename);
		_course.setCourseStartDate(startDate);
		_course.setCourseEndDate(endDate);
		_course.setCourseUnit(units);
		_course.setMaxSize(maxSize);
		_course.setLecturerid(lecturerid);
		cService.editCourse(_course);			
	}
  
    @RequestMapping("/manageCourses/delete/{id}")
    public void deleteCourse(@PathVariable("id") int id) {    	
		cService.removeCoursebyId(id);		
		}

    @GetMapping("/manageUsers")
    List<User> userlist() {return uService.findAllUsers();}
    @RequestMapping("/manageUsers/create/{u}/{p}/{n}/{r}")
    public void createUser(@PathVariable("u")String username,@PathVariable("p") String password,@PathVariable("n") String name,@PathVariable("r") String role)
    {  	
    	if (role.equals("student")) {
    	User u = new User(username, password, name, RoleType.STUDENT);    	
    	User u1 = uService.createUser(u);
    	Student s = new Student (u1.getUserid(),name);
    	Student s1 =sService.createStudent(s);
    	}
    	if (role.equals("lecturer")) {
    	User u = new User(username, password, name, RoleType.LECTURER);
        User u1 = uService.createUser(u);}
    	if (role.equals("admin")) {
        	User u = new User(username, password, name, RoleType.ADMIN);
            User u1 = uService.createUser(u);}
    	}
    
    @RequestMapping("/manageUsers/edit/{u}/{p}/{n}/{id}")
    public void editUser(@PathVariable("u")String username,@PathVariable("p") String password,@PathVariable("n") String name,@PathVariable("id")int id)
    {  	
    	User u = uService.findUser(id);    	
    	u.setName(name);
    	u.setPassword(password);
    	u.setUsername(username);
    	User u1 = uService.editUser(u);
    	if
    	(u.getRole().equals(RoleType.STUDENT)){    	
    	Student s = sService.findStudent(id);
    	s.setName(name);
    	Student s1 =sService.editStudent(s);} 	
    	
    	}
    			
    
    @GetMapping("/manageUsers/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User udata = uService.findUser(id);
		if (udata.getUserid()>0) {
			return new ResponseEntity<>(udata, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    @RequestMapping("/manageUsers/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
		try {
			uService.removeUserById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
    }
    @RequestMapping("/manageUsers/edit/{id}")
	public ResponseEntity<User> editUser(@PathVariable("id") int id, @RequestBody User user) {
		User uData = uService.findUser(id);		
		if (uData.getUserid()>0) {			
			return new ResponseEntity<>(uService.editUser(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}