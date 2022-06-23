package iss.sa54.team7.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa54.team7.model.*;

public interface StudentCourseRepo extends JpaRepository<Student_Course, Integer> {
	
	/*
	 * @Query("SELECT sc Student_Course sc WHERE sc.courseid = :cID") public
	 * ArrayList<Student_Course> findAllStudentsByCourseID(@Param("cID")Integer
	 * courseID);
	 * 
	 * @Query(" SELECT sc FROM Student_Course sc WHERE sc.studentid = :sID") public
	 * ArrayList<Student_Course> findCoursesByStudentID(@Param("sID")Integer
	 * studentID);
	 * 
	 * @Query("SELECT sc.grade FROM Student_Course sc WHERE sc.courseid = :cID")
	 * public ArrayList<Student_Course> getAllGradesByCourseID(@Param("cID")Integer
	 * courseID);
	 * 
	 * @Query("SELECT sc FROM Student_Course sc WHERE sc.courseid = :cID AND sc.studentid = :sID"
	 * ) public Student_Course
	 * getStudentCourseByCourseAndStudentID(@Param("cID")Integer
	 * courseID, @Param("sID")Integer studentID);
	 */

}
