package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.in28minutes.springboot"})
public class SpringRestControllerFullAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestControllerFullAppApplication.class, args);
	}

}
