package iss.sa54.team7;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import iss.sa54.team7.model.Course;
import iss.sa54.team7.model.RoleType;
import iss.sa54.team7.model.Student;
import iss.sa54.team7.model.Student_Course;
import iss.sa54.team7.model.User;
import iss.sa54.team7.service.*;


@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
public class Team7App {
	@Autowired
	UserService uService;
	@Autowired
	CourseService cService;
	@Autowired
	StudentCourseService scService;
	@Autowired
	StudentService sService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Team7App.class, args);

	   };
	   
		 /* @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		  return args ->{
				
			  User user1 = new User("Ray", "rrr", "Ray", RoleType.STUDENT);	
			  User u = uService.createUser(user1);
			  Student s1 = new Student(u);
			  sService.createStudent(s1);
			  
			  User user2 = new User("Tin", "ttt", "Tin", RoleType.LECTURER); 
			  User user3 = new User("Jean", "jjj", "Jean",RoleType.ADMIN); 
			  
			  uService.createUser(user2); 
			  uService.createUser(user3);
			  
			  LocalDate dt1 = LocalDate .of(2022, 6, 15); LocalDate dt2 = LocalDate
			  .of(2022, 12, 15); LocalDate dt3 = LocalDate .of(2022, 4, 30); LocalDate dt4
			  = LocalDate .of(2023, 7, 20);
			  
			  Course c1 = new Course("Java Spring",dt1,dt2, 3, 50, 2); Course c2 = new
			  Course("Python ML", dt3,dt4, 4, 40, 2); cService.createCourse(c1);
			  cService.createCourse(c2);}; }*/
				 
									  
							//Student_Course sc1 = new Student_Course(6,1,"A");
							//scService.createCourse(sc1);
									 //};
				;
		 }

	