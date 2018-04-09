package com.br.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CorsConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/api/**")
	.allowedOrigins("http://localhost:4200","http://localhost:8080")
	.allowedMethods("*")
	.allowedHeaders("*")
	.allowCredentials(false)
	.maxAge(3600);
	}
}