package com.ktech.a2zschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class A2ZSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(A2ZSchoolApplication.class, args);
	}

}
