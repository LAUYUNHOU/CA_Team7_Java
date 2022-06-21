package iss.sa54.team7.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa54.team7.model.*;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query("SELECT s FROM Student s and Student_Course sc WHERE sc.courseID = :courseID AND s.courseID = sc.courseID")
	public ArrayList<Student> findAllStudentsByCourseID(@Param("courseID")Integer courseID);
	
	@Query("SELECT sc FROM Student_Course sc WHERE sc.courseID = :cID AND s.studentID = :sID")
	public Student_Course getCourseGradeByStudentAndCourseID(@Param("cID")Integer courseID, @Param("sID")Integer studentID);
	
}
