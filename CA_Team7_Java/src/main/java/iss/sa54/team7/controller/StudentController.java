package iss.sa54.team7.controller;
import java.util.ArrayList;
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
import iss.sa54.team7.repo.StudentCourseRepo;
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
    @Autowired
    private StudentCourseRepo screpo;

    
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
	
	@RequestMapping("/courses/{courseid}")
	public String studentEnrol(Model model, @PathVariable("courseid") Integer cID) {
		Course coursedetails = cService.findCourse(cID);
		model.addAttribute("coursedetails", coursedetails);
		return "courseDetails";
	}
	
	//saveEnrol method
	@RequestMapping("/viewgrade")
	public String viewPerformance(Model model, HttpSession session) {
		// for printing all courses and respective grade of this student
		Integer studentID = (Integer) session.getAttribute("userSession");
		
		List<Student_Course> list1 = scService.findAllStudentCourses();
		ArrayList<Student_Course> list2 = new ArrayList<Student_Course>();
		for (Student_Course item : list1) {
			if (item.getStudentid() == studentID) {
				list2.add(item);
			}
		}
		model.addAttribute("coursesByStudent", list2);
		
		// compute GPA then save to DB
		 Student thisStu = sService.findStudent(studentID);
		 double calcGpa = calculateGPA(studentID);
		 thisStu.setGpa(calcGpa);
		 sService.editStudent(thisStu);
		// for printing personal student details and gpa
		model.addAttribute("studentdetails", thisStu);
			
		return "performance";
	}
	
	public double calculateGPA (Integer studentid) {
		List<Student_Course> sclist = scService.findAllStudentCourses();
		double totalscore = 0;
		int totalunit = 0;
		
		for (Student_Course item : sclist) {
			if (item.getStudentid() == studentid) {
				// calc total course unit
				Integer cID = item.getCourseid();
				int courseUnit = cService.findCourse(cID).getCourseUnit();
				totalunit += courseUnit;
				
				// calc total score based on grade conversion
				if (item.getGrade() == "A") {
					totalscore += 5.0;
				}
				else if (item.getGrade() == "B") {
					totalscore += 4.0;
				}
				else if (item.getGrade() == "C") {
					totalscore += 3.0;
				}
				else if (item.getGrade() == "D") {
					totalscore += 2.0;
				}
				else if (item.getGrade() == "E") {
					totalscore += 1.0;
				}
				else {
					totalscore += 0;
				}
			}
		}
		// calc GPA
		return totalscore / totalunit;
	}
	
	
	@RequestMapping("/courses/{courseid}/enrol")
    public String studentEnrol(@PathVariable("courseid") Integer cID, HttpSession session, Model model) {
        Integer studentId = (Integer) session.getAttribute("userSession");
        Student_Course sc = new Student_Course(cID, studentId);
        screpo.saveAndFlush(sc);
        Course c = cService.findCourse(cID);
        model.addAttribute("enrolledcourse", c);
        return "courseEnrolledConfirmed";
    }
}
