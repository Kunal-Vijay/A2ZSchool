package com.ktech.a2zschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ktech.a2zschool.repository")
@EntityScan("com.ktech.a2zschool.model")
public class A2ZSchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(A2ZSchoolApplication.class, args);
	}
}
