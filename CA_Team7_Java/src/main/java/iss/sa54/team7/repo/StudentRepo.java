package iss.sa54.team7.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iss.sa54.team7.model.*;

public interface StudentRepo extends JpaRepository<Student, Integer> {

		
}
