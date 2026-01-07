package com.example.sender_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SenderEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenderEmailApplication.class, args);
	}

}
