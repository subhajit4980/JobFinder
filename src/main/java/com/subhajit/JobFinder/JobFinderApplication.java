package com.subhajit.JobFinder;

import com.subhajit.JobFinder.Repository.PostRepository;
import com.subhajit.JobFinder.Repository.SearchRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication()
public class JobFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobFinderApplication.class, args);
	}

}
