package iss.sa54.team7.controller;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import iss.sa54.team7.model.Course;
import iss.sa54.team7.model.Student;
import iss.sa54.team7.model.Student_Course;
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.LecturerService;
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
	 */
    
	@GetMapping("/student/{studentID}")
	public String viewCoursesAttednd(Model model, @PathVariable("studentID") Integer stuID){
		List<Student_Course> courselist = scService.findCoursesByStuID(stuID);
		model.addAttribute("Student_Course", courselist);
		return "student";
	}

}
