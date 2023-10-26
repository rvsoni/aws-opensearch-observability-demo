package com.rvsoni.ecom.user.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.rvsoni.ecom")
@EntityScan(basePackages = "com.rvsoni.ecom")
@ComponentScan(basePackages = "com.rvsoni.ecom")
@SpringBootApplication
public class EComUserAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComUserAddressApplication.class, args);
	}

}
