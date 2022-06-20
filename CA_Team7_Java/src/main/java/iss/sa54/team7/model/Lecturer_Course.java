package iss.sa54.team7.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data

public class Lecturer_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "courseID")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "studentID")
    private Lecturer lecturer;
    
    @Column(name="currenroll")
    private boolean currEnroll;

	public Lecturer_Course(Lecturer lecturer) {
		super();
		this.lecturer = lecturer;
	}	
}
