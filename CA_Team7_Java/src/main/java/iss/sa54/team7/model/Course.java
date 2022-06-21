package iss.sa54.team7.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Course {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;

    @Column(name = "coursename")
    private String courseName;
    @Column(name="coursestartdate")
    private Date courseStartDate;
    @Column(name="courseenddate")
    private Date courseEndDate;
    @Column(name="courseunit")
    private int courseUnit;
    @Column(name ="maxSize")
    private int maxSize;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<Student_Course> studentCourses = new ArrayList<>();
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<Lecturer_Course> lecturerCourses = new ArrayList<>();
       
	public Course(String courseName, Date courseStartDate, Date courseEndDate, int courseUnit, int maxSize) {
		super();
		this.courseName = courseName;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseUnit = courseUnit;
		this.maxSize = maxSize;
	}
}
