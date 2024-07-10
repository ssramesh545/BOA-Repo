package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boa.service.Customer;
import com.boa.service.CustomerImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public Customer getCustomerImpl() {
		return new CustomerImpl();
	}

}
