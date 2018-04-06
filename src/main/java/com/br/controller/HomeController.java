package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.domain.User;
import com.br.service.UserService;

@RestController
@RequestMapping("/api/pages")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}

	@GetMapping("/add")
	public ResponseEntity<String> addUser() {
		userService.addUser(new User("teste","111"));
		return ResponseEntity.ok("User add success!");
	}

}