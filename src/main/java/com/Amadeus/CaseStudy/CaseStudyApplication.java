package com.Amadeus.CaseStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
@Configuration
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.Amadeus.CaseStudy")
@EntityScan("com.Amadeus.CaseStudy")
@EnableJpaRepositories(basePackages = "com.Amadeus.CaseStudy.repositories")

public class CaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseStudyApplication.class, args);
	}

}
