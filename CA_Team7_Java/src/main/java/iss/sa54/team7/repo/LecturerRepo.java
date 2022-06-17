package iss.sa54.team7.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import iss.sa54.team7.model.*;

public interface LecturerRepo extends JpaRepository<Lecturer, Integer> {
	
	//@Query("SELECT c.name from Course c where c.ID )")	

}
