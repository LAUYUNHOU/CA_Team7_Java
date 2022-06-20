package iss.sa54.team7.model;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Student_Course> studentCourses;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Lecturer_Course> lecturerCourses;

    public Course(String courseName, Student_Course... studentCourses) {
        this.courseName = courseName;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.courseUnit = courseUnit;
        for(Student_Course studentCourse : studentCourses) studentCourse.setCourse(this);
        this.studentCourses = Stream.of(studentCourses).collect(Collectors.toSet());
    }
    
    public Course(String courseName, Lecturer_Course... lecturerCourses) {
        this.courseName = courseName;
        for(Lecturer_Course lecturerCourse : lecturerCourses) lecturerCourse.setCourse(this);
        this.lecturerCourses = Stream.of(lecturerCourses).collect(Collectors.toSet());
    }
}
