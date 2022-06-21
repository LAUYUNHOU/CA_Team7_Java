package iss.sa54.team7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iss.sa54.team7.model.Course;
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.LecturerService;
import iss.sa54.team7.service.StudentService;;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private StudentService sService;
    @Autowired
    private CourseService cService;    
    @Autowired
    private LecturerService lService;
    
    @GetMapping("/manageCourses")
    List<Course> courselist() {return cService.findAllCourses();}
    @PostMapping("/manageCourses")
    public ResponseEntity<Course> createCourse(@RequestBody Course newCourse)
    {try {
    	Course c = cService.createCourse
    			(new Course(newCourse.getCourseName(), 
    			newCourse.getCourseStartDate(), newCourse.getCourseEndDate(),
    			newCourse.getCourseUnit(),newCourse.getMaxSize()));
    			return new ResponseEntity<>(c, HttpStatus.CREATED);
    			} catch (Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    			} }    	
    @GetMapping("/manageCourses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id) {
		int i = id;
		Optional<Course> cData = Optional.ofNullable(cService.findCourse(i));
		if (cData.isPresent()) {
			return new ResponseEntity<>(cData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}    
    @PutMapping("/manageCourses/edit/{id}")
	public ResponseEntity<Course> editStudent(@PathVariable("id") int id, @RequestBody Course course) {
		Optional<Course> cData = Optional.ofNullable(cService.findCourse(id));
		if (cData.isPresent()) {
			Course _course = cData.get();			
			_course.setCourseName(course.getCourseName());
			_course.setCourseStartDate(course.getCourseStartDate());
			_course.setCourseEndDate(course.getCourseEndDate());
			_course.setCourseUnit(course.getCourseUnit());
			_course.setMaxSize(course.getMaxSize());
			return new ResponseEntity<>(cService.editCourse(_course), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    @DeleteMapping("/manageCourses/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") int id) {
		try {
			cService.removeCoursebyId(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

    //-------------------
    //Lecture
    //-------------------
    @GetMapping("/manageLecturer")
    List<Lecturer> lecture() {return lService.findAllLecturer();}
    @PostMapping("/manageLecture")
    public ResponseEntity<Lecturer> createCourse(@RequestBody Lecturer newLecturer)
    {try {
    	Lecturer l = lService.createLecturer
    			(new Lecturer(newLecturer.getLecturerName()));
    			return new ResponseEntity<>(l, HttpStatus.CREATED);
    			} catch (Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    			} }  
    
    @GetMapping("/manageLecturer/{id}")
	public ResponseEntity<Lecturer> getLecturerById(@PathVariable("id") Integer id) {
		int i = id;
		Optional<Lecturer> lData = Optional.ofNullable(lService.findLecturer(i));
		if (lData.isPresent()) {
			return new ResponseEntity<>(lData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}   
    
    @PutMapping("/manageLecturer/edit/{id}")
	public ResponseEntity<Lecturer> editLecturer(@PathVariable("id") int id, @RequestBody Course course) {
		Optional<Lecturer> lData = Optional.ofNullable(lService.findLecturer(id));
		if (lData.isPresent()) {
			Lecturer _lecturer = lData.get();			
			_lecturer.setLecturerName(Lecturer.getLecturerName());
			return new ResponseEntity<>(lService.editLecturer(_lecturer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
