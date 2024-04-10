package com.example.MicroserviceChatGPT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class MicroserviceChatGptApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceChatGptApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
