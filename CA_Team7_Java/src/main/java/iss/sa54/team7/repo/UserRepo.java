package iss.sa54.team7.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import iss.sa54.team7.model.*;

public interface UserRepo extends JpaRepository<User, Integer> {

}
