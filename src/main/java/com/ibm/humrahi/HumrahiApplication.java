package com.ibm.humrahi;

import java.util.Base64;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ibm.humrahi.entity.User;
import com.ibm.humrahi.service.UserServiceImpl;

@SpringBootApplication
public class HumrahiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumrahiApplication.class, args);
	}
	
	@Bean
    CommandLineRunner runner(UserServiceImpl userService) {
		String str = new String("1111");
		
		User user  = new User(1L, 
				"8826612535", "Manoj","Behl", "Agent",
				new String( Base64.getEncoder().encode(str.getBytes())) );
		
		
		user.setAadharNumber("AHJAHJAHA");
		user.setCity("Gurgaon");
		user.setGender("male");
		return args -> {
            userService.create(user);
        };
    }


}
