package iss.sa54.team7.controller;

import java.util.ArrayList;
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
import iss.sa54.team7.service.CourseService;
import iss.sa54.team7.service.LecturerService;
import iss.sa54.team7.service.StudentService;;


@Controller
@RequestMapping(value="/lecturer")
public class LecturerController {
	@Autowired
	private StudentService sService;
    @Autowired
    private CourseService cService;
	
	@GetMapping("/courses")
	public String viewCoursesTaught(Model model, Integer lectID){
		List<Course> courselist = cService.findCoursesByLectID(lectID);
		model.addAttribute("courses", courselist);
		return "courses";
	}

	@GetMapping("/courses/{courseID}")
	public String viewCourseEnrolled(Model model, @PathVariable("courseID") Integer courseID){
		List<Student> slist = sService.findAllStudentsByCourse(courseID);
		model.addAttribute("students", slist);
		
		Course course = cService.findCourse(courseID);
		model.addAttribute("courseName", course.getCourseName());
		return "enrolment";
	}
	
	@GetMapping("/enrolment")
	public String populateGrades(Model model) {
		List<String> options = new ArrayList<String>();
		options.add("A"); options.add("B");
		options.add("C"); options.add("D");
		options.add("E"); options.add("F");
		model.addAttribute("options", options);
		return "enrolment";
	}

	@PostMapping("/grade")
	public String gradeStudent(@ModelAttribute("students") Student s){
		
		return "enrolment";
	}
}
	
	/*
	<form action="" th:object="${product}" th:action="@{/product/save}" method="get">
        <fieldset>
		     <input type="hidden" th:field="*{productId}"/>  
		</fieldset>
		@GetMapping("/save")
		
	public String saveProductForm(@ModelAttribute("product") @Valid Product product, BindingResult binding, Model model) {
		if (binding.hasErrors()) {
			return "productform";
		}
		prepo.save(product);
		return "forward:/product/listproducts";
	}
	
	@GetMapping("/listproducts")
	public String listProducts(Model model) {
		model.addAttribute("products", prepo.findAll());
		return "products";
	}
	
	@GetMapping("/edit/{id}")
	  public String showEditForm(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("product", prepo.findById(id).get());
		return "productform";
	  }
	
}

@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrRejectCourse(@ModelAttribute("approve") @Valid Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (result.hasErrors())
			return new ModelAndView("manager-course-detail");
		Course c = cService.findCourse(id);
		CourseEvent ce = new CourseEvent();
		if (approve.getDecision().trim().equalsIgnoreCase(CourseEventEnum.APPROVED.toString())) {
			ce.setEventType(CourseEventEnum.APPROVED);
			c.setStatus(CourseEventEnum.APPROVED);
		} else {
			ce.setEventType(CourseEventEnum.REJECTED);
			c.setStatus(CourseEventEnum.REJECTED);*/



/* from controllerdemo prof demo
	@GetMapping("/add")
	public String loadForm(Model model) {
		Book b = new Book();
		model.addAttribute("book", b);
		return "bookform";
	}
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute("book") Book b) {
		brepo.save(b);
		return "forward:/book/list";

	}
	
	@RequestMapping("/course/list")
	public String listPage(Model model) {
		List<Course> courselist =  cService.findAllCourses();
		model.addAttribute("coursedata",courselist);
		return "course";
	}
    
}


@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home"; */
