package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}



// netstat -ano | findstr :8080
// taskkill /PID **** /f

// to run the application using CMD to the following:
// Maven -> install -> cmd= java -jar NAME.jar --server.port=8080
// YOUTUBE = https://www.youtube.com/watch?v=9SGDpanrc8U&ab_channel=Amigoscode