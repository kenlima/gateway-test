package com.kenlima.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class ResourceApplication extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().requestMatchers(CorsUtils::isCorsRequest).permitAll().anyRequest().authenticated();
	}

	@RequestMapping("/")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello world");
		System.out.println("access");

		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
	@Bean
	public HeaderHttpSessionStrategy sessionStrategy() {
		HeaderHttpSessionStrategy strategy = new HeaderHttpSessionStrategy();
		return strategy;
	}
}
