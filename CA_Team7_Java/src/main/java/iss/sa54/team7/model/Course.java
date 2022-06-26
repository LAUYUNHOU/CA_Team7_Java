package iss.sa54.team7.model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Course {  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseid;

    @Column(name = "coursename")
    private String courseName;
    @Column(name="coursestartdate")
    private LocalDate courseStartDate;
    @Column(name="courseenddate")
    private LocalDate courseEndDate;
    @Column(name="courseunit")
    private int courseUnit;
    @Column(name ="maxsize")
    private int maxSize;
    @Column(name ="lecturerid")
    private int lecturerid;
    
    //@ManyToMany
    //@JoinTable(name="student_course", 
    		//joinColumns = {@JoinColumn(name = "course_courseid")},
    		//inverseJoinColumns = {@JoinColumn(name="student_studentid")})
	//private List<Student> sc;

	public Course(String courseName, LocalDate courseStartDate, LocalDate courseEndDate, int courseUnit, int maxSize,
			int lecturerid) {
		super();
		this.courseName = courseName;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseUnit = courseUnit;
		this.maxSize = maxSize;
		this.lecturerid = lecturerid;		
		//rmb to match userID with lectID on course is created
	}
       
}
