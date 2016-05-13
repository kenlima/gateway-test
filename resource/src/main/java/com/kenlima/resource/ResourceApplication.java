package com.kenlima.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
//@EnableRedisHttpSession
public class ResourceApplication {

	@RequestMapping("/")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello world");
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
/*
	@Bean
	public HeaderHttpSessionStrategy sessionStrategy() {
		HeaderHttpSessionStrategy strategy = new HeaderHttpSessionStrategy();
		return strategy;
	}
	*/
}
