package iss.sa54.team7.model;
//import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Admin")
@Data
@NoArgsConstructor
public class Admin {
	@Id
    @Column(name = "adminId")
    private int adminId;
	private String name;
	@OneToOne
	private User user3;
	
    public Admin(String name) {
		super();
		this.name = name;
		this.adminId = user3.getUserId();
	}
	
}
