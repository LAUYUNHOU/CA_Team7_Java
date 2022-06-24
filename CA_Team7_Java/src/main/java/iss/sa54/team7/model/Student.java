package iss.sa54.team7.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Student {  
    @Id
    private int studentid;
    @Column(name="name")
    private String name;   
    @Column(name="gpa")
    private double gpa;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	  
	@JoinColumn(name = "studentid")
    private List<Student_Course> studentCourses;
    
    @OneToOne
    private User user;
	
	public Student(String name, User user) {
		super();		
		this.name = name;
		this.user = user;
		this.studentid = user.getUserid();
	} 
      
}
