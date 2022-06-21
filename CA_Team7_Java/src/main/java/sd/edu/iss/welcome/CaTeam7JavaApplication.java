package sd.edu.iss.welcome;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
public class CaTeam7JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaTeam7JavaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	   return args ->{
		   
//		   SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
//		   String hashedPassword = encoder.encode("mmm");
//		   String hashedPassword1 = encoder.encode("ttt");
//		   String hashedPassword2 = encoder.encode("jjj");
//		   
//		   User user1 = new User("Mike", hashedPassword, RoleType.STUDENT);
//		   User user2 = new User("Tin", hashedPassword1, RoleType.LECTURER);
//		   User user3 = new User("Jean", hashedPassword2, RoleType.ADMIN);
//		   urepo.save(user1);
//		   urepo.save(user2);
//		   urepo.save(user3);
		   
		   
	   };
	 }

}
