package com.br;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.domain.User;
import com.br.service.UserService;

@SpringBootApplication
@RestController
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}
	
	@GetMapping("/secured")
	public String secured() {
		return "Secured!!";
	}
	
	@GetMapping("/add")
	public ResponseEntity<String> addUser() {
		userService.addUser(new User("teste","111"));
		return ResponseEntity.ok("User add success!");
	}
}

