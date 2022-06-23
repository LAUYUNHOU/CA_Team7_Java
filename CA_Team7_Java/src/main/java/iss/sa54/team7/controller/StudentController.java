package iss.sa54.team7.controller;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import iss.sa54.team7.model.Course;
import iss.sa54.team7.model.Student_Course;
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.StudentCourseService;
import iss.sa54.team7.service.StudentService;;


@Controller
@RequestMapping(value="/student")

public class StudentController {
	@Autowired
	private StudentService sService;
    @Autowired
    private CourseService cService;
    
    @Autowired
    private StudentCourseService scService;
    
	/*
	 * @GetMapping("/courses") public String viewCoursesTaught(Model model, Integer
	 * lectID){ List<Course> courselist = cService.findCoursesByLectID(lectID);
	 * model.addAttribute("courses", courselist); return "courses"; }
	 
    
	@GetMapping("/student/{studentID}")
	public String viewCoursesAttednd(Model model, @PathVariable("studentID") Integer stuID){
		List<Student_Course> courselist = scService.findCoursesByStudentID(stuID);
		model.addAttribute("Student_Course", courselist);
		return "student";
	}*/
	
	//This will show all the courses from Schools
	
	@RequestMapping("/findAllCourse")
	public String FindAllCourse(Model model){
		List<Course> courselist = cService.findAllCourses();
		model.addAttribute("courses", courselist);
		return "courses";
	}

}
