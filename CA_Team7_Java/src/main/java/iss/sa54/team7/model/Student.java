package iss.sa54.team7.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Student {  
    @Id
    private int studentID;
    @Column(name="lastname")
    private String lastName;
    @Column(name="firstmidname")
    private String firstMidName;
    @Column(name="enrollmentdate")
    private Date enrollmentDate;
    @Column(name="gpa")
    private double gpa;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Student_Course> studentCourses = new HashSet<>();
    @OneToOne
    private User user1;
    

    public Student(String lastName, String firstMidName, Date enrollmentDate, double gpa) {
        this.lastName = lastName;
        this.firstMidName = firstMidName;
        this.enrollmentDate = enrollmentDate;
        this.gpa = gpa;
        this.studentID = user1.getUserId();
    }
}
