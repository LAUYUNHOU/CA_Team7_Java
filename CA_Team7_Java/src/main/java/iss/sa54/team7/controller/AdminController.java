package iss.sa54.team7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/manageCourses") Course createCourse(@RequestBody Course newCourse)
    {return cService.createCourse(newCourse);}
    @GetMapping("/manageCourses/{id}") Course find(@PathVariable int id) {
    return cService.findCourse(id);}
    //@PutMapping("/manageCourse/{id}"){return cService.editCourse(course);}
    @DeleteMapping("/manageCourses") void removeCourse(Course course)
	{cService.removeCourse(course);}
	/*
	 
	 * @GetMapping("/employees/{id}") Employee one(@PathVariable Long id) {
	 * 
	 * return repository.findById(id) .orElseThrow(() -> new
	 * EmployeeNotFoundException(id)); }
	 * 
	 * @PutMapping("/employees/{id}") Employee replaceEmployee(@RequestBody Employee
	 * newEmployee, @PathVariable Long id) {
	 * 
	 * return repository.findById(id) .map(employee -> {
	 * employee.setName(newEmployee.getName());
	 * employee.setRole(newEmployee.getRole()); return repository.save(employee); })
	 * .orElseGet(() -> { newEmployee.setId(id); return
	 * repository.save(newEmployee); }); }
	 * 
	 * @DeleteMapping("/employees/{id}") void deleteEmployee(@PathVariable Long id)
	 * { repository.deleteById(id); }
	 */
	
}
