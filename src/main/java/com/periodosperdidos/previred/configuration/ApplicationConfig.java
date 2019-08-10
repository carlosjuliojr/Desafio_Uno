package com.periodosperdidos.previred.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.periodosperdidos.previred.utils.WriteFileInputOutput;

/**
 * 
 * @author Julio Jaimes
 * @apiNote Class has the beans need to the system
 *
 */

@Configuration
public class ApplicationConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

	@Bean
	public WriteFileInputOutput writer() {
		return new WriteFileInputOutput();
	}

}
