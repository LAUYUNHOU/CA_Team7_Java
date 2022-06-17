package iss.sa54.team7.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lecturer")
@NoArgsConstructor

public class Lecturer {
	@Id
	@Column(name = "lecturerID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String lecturerID;
	@Column(name = "lecturerName")
	private String lecturerName;
    
    @OneToMany(mappedBy="lecturers")  
    private Lecturer_Course LecturerCourse;

	public String getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public Lecturer_Course getLecturerCourse() {
		return LecturerCourse;
	}

	public void setLecturerCourse(Lecturer_Course lecturerCourse) {
		LecturerCourse = lecturerCourse;
	}

	public Lecturer(String lecturerID, String lecturerName, Lecturer_Course lecturerCourse) {
		super();
		this.lecturerID = lecturerID;
		this.lecturerName = lecturerName;
		LecturerCourse = lecturerCourse;
	}
    
    
    
}


