package iss.sa54.team7.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	// HERERE
	@GetMapping("/courses/{courseID}/enrolment")
	public String populateGrades(Model model, @PathVariable("courseID") Integer courseID) {
		List<Student_Course> sc = (List<Student_Course>) scService.findAllStudentCourses();
		Set<Student_Course> list = new HashSet<Student_Course>();
		for (Student_Course item:sc) {
			if (item.getCourseid()==courseID) {
				list.add(item);
			}
		}
		model.addAttribute("students", list);
		
		Course c = cService.findCourse(courseID);
		model.addAttribute("cou", c);
		return "enrolment";
	}
	
	@GetMapping("/courses/{courseid}/grade/{studentid}")
	public String showStudentGradePage(@PathVariable("courseid") Integer courseid, @PathVariable("studentid") Integer studentid, Model model) {
		Course c = cService.findCourse(courseid);
		model.addAttribute("course", c);
		Student_Course sc = scService.findStudentCourse(studentid);
		model.addAttribute("sc", sc);
		System.out.println(sc);
		return "gradeStudentPage";
	}
	
	@PostMapping("/courses/{courseid}/grade/{studentid}")
	public String updateStudentGrade(@PathVariable("courseid") Integer courseid, @PathVariable("studentid") Integer studentid, @ModelAttribute("stugrade") String stugrade) {
		ArrayList<Student_Course>list = scService.findAllStudentCourses();
		for (Student_Course sc : list) {
			if (sc.getCourseid()==courseid && sc.getStudentid()==studentid) {
				sc.setGrade(stugrade);
				scService.editCourse(sc);
			}
		}
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

