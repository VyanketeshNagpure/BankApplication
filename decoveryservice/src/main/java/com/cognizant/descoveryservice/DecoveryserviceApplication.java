package com.cognizant.descoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DecoveryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecoveryserviceApplication.class, args);
	}

}
