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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import iss.sa54.team7.model.Course;
import iss.sa54.team7.model.Student;
import iss.sa54.team7.model.Student_Course;
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.StudentCourseService;
import iss.sa54.team7.service.StudentService;;


@Controller
@RequestMapping(value="/lecturer")
public class LecturerController {
	@Autowired
	private StudentService sService;
    @Autowired
    private CourseService cService;
    @Autowired
    private StudentCourseService scService;
	
	@RequestMapping("/courses")
	public String FindAllCourse(Model model, HttpSession session){
		Integer lecid = (Integer) session.getAttribute("userSession");
		List<Course> courselist = cService.findCoursesByLectID(lecid);
		model.addAttribute("courses", courselist);
		return "leccourses";
	}

	/*
	 * @GetMapping("/courses/{courseID}") public String viewCourseEnrolled(Model
	 * model, @PathVariable("courseID") Integer courseID, HttpSession session){
	 * List<Student_Course> slist = scService.findAllStudentsByCourseID(courseID);
	 * model.addAttribute("students", slist);
	 * 
	 * List<Student_Course> gradelist =
	 * scService.getAllStudentsGradesByCourseID(courseID);
	 * model.addAttribute("gradelist", gradelist); return "enrolment";
	 
	}*/
	
	@GetMapping("/courses/{courseID}/enrolment")
	public String populateGrades(Model model, @PathVariable("courseID") Integer cID) {
		List<String> options = new ArrayList<String>();
		options.add("A"); options.add("B");
		options.add("C"); options.add("D");
		options.add("E"); options.add("F");
		model.addAttribute("gradeoptions", options);
		
		List<Student_Course> sc = (List<Student_Course>) scService.findStudentCourse(cID);
		model.addAttribute("students", sc);
		
		
		
		return "enrolment";
	}

	/*
	 * @PostMapping("courses/{courseID}/grade") public String
	 * gradeStudent(@PathVariable("courseID") Integer
	 * cID, @ModelAttribute("gradeform") String grade, HttpSession session){ //when
	 * got time then see if can lock the grade form // when got EVEN MORE TIME then
	 * check for session login time vs course enddate and lock it
	 * ArrayList<Student_Course> sclist =
	 * scService.getAllStudentsGradesByCourseID(cID); Integer sID = (Integer)
	 * session.getAttribute("userSession"); for (Student_Course sc : sclist) { if
	 * (sc.getStudentid() == sID) { sc.setGrade(grade); scService.editCourse(sc); }
	 * } return "enrolment"; }
	 */
	
	@RequestMapping("/studentSearch")
    	public String studentSearch(Student student, Model model, Integer studentID) {

        	Student foundStudent = sService.findStudent(studentID);
        	model.addAttribute("foundStudent", foundStudent);

        	return "studentSearch";
    }

}

