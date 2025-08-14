package com.paybrook.eventregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.paybrook.eventregistration" })
@EntityScan(basePackages = { "com.paybrook.eventregistration" })
@SpringBootApplication(scanBasePackages = { "com.paybrook.eventregistration"})
@ComponentScan(basePackages = "com.paybrook.eventregistration")
public class SpringBootAndSqLiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAndSqLiteApplication.class, args);
	}

}
