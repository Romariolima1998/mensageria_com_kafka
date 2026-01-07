package com.example.scheduled_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ScheduledEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledEmailApplication.class, args);
	}

}
