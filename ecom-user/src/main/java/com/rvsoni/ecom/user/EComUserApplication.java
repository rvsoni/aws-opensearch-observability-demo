package com.rvsoni.ecom.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages = "com.rvsoni.ecom")
@EntityScan(basePackages = "com.rvsoni.ecom")
@ComponentScan(basePackages = "com.rvsoni.ecom")
@SpringBootApplication
public class EComUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComUserApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
