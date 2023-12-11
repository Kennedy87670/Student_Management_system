package com.admin_student.spring_studentMs;

import com.admin_student.spring_studentMs.entity.Role;
import com.admin_student.spring_studentMs.entity.User;
import com.admin_student.spring_studentMs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringStudentMsApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.STAFF);
		if (null== adminAccount){
			User user = new User();


			user.setFirstname("staff");
			user.setLastname("staff");
			user.setUserName("staff");
			user.setEmail("staff@gmail.com");
			user.setPassword(new BCryptPasswordEncoder().encode("staff"));
			user.setRole(Role.STAFF);
			user.setEmail("staff@gmail.com");
			userRepository.save(user);
		}
	}
}
