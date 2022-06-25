package iss.sa54.team7.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa54.team7.model.RoleType;
import iss.sa54.team7.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public User findUserByUsername(String name);
	
	//@Query()
	//public ArrayList<User> findUsersByRoleType(RoleType role);
}
