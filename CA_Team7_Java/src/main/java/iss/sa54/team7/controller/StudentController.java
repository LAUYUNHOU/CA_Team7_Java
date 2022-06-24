package iss.sa54.team7.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import iss.sa54.team7.model.Course;
import iss.sa54.team7.model.Student;
import iss.sa54.team7.model.Student_Course;
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.StudentCourseService;
import iss.sa54.team7.service.StudentService;;


@Controller
@RequestMapping("/student")
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
	@RequestMapping("/courses")
	public String FindAllCourse(Model model){
		List<Course> courselist = cService.findAllCourses();
		model.addAttribute("courses", courselist);
		return "courses";
	}
	
	@RequestMapping("/courses/{courseID}/")
	public String studentEnrol(Model model, @PathVariable("courseID") Integer cID) {
		Course coursedetails = cService.findCourse(cID);
		model.addAttribute("coursedetails", coursedetails);
		return "courseDetails";
	}
	
	//saveEnrol method
	
	@RequestMapping("/viewgrade")
	public String viewPerformance(Model model, HttpSession session) {
		// for printing all courses and respective grade of this student
		Integer studentID = (Integer) session.getAttribute("userSession");
		List<Student_Course>list = scService.findCoursesByStudentID(studentID);
		model.addAttribute("coursesByStudent", list);
		
		// for printing personal student details and gpa
		Student stu = sService.findStudent(studentID);
		model.addAttribute("studentdetails", stu);
		return "performance";
	}
	
	
}
