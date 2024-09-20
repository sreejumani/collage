package com.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages= {"com.subject"})
@EntityScan(basePackages= {"com.subject"})
@ComponentScan(basePackages= {"com.subject"})
@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectApplication.class, args);
	}

}
