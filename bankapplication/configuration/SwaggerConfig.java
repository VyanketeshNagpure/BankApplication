package com.cognizant.bankapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI swaggerConfigInfo() {
		
		return new OpenAPI()
					.info(new Info().title("Banking Application")
									.description("Problem statement : create a list of accounts with positive balance, "
									+ "1000$+ MAB and valid contact info , "
									+ "then share Equity instrument brochures for investment on contact info"));
		
	}
    // Swagger URL
    //http://localhost:8083/swagger-ui/index.html
	
	 
}
