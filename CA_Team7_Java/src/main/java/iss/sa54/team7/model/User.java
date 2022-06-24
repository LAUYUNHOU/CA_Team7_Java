package iss.sa54.team7.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username;
	private String password;
	private String name;
	private RoleType role;
	
	public User(String username, String password, String name, RoleType role) {
		super();
		this.username = username;
		this.password = password;
		this.name= name;
		this.role = role;
	}
	
	@OneToOne(mappedBy="user")
	private Student student;

	
}
