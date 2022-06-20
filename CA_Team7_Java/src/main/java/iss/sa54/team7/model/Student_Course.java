package sg.team7.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;  

@Data
@NoArgsConstructor
@Entity
public class Student_Course {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseID")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentID")
    private Student student;

    private String grade;
    private int score;
    

    public Student_Course(Student student, String grade, int score) {
        this.student = student;
        this.grade = grade;
        this.score = score;
        
    }

   
}