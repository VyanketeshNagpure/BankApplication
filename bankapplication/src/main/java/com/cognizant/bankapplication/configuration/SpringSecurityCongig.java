package com.cognizant.bankapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityCongig {
	
	@Bean
	SecurityFilterChain defaultSecurityFileterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
		return http.build();
	}

}
