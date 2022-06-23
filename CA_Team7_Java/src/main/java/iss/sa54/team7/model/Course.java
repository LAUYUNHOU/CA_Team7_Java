package iss.sa54.team7.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Course {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;

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
    @Column(name ="lecturerID")
    private int lecturerid;

	/*
	 * @OneToMany(mappedBy = "course", cascade = CascadeType.ALL) private
	 * List<Student_Course> studentCourses;
	 */

	public Course(String courseName, Date courseStartDate, Date courseEndDate, int courseUnit, int maxSize,
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
