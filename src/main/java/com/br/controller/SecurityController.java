package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.service.UserService;

@RestController
@RequestMapping("/api/secured")
public class SecurityController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/protected")
	public String home() {
		return "Página protegida acessada com sucesso!";
	}
}