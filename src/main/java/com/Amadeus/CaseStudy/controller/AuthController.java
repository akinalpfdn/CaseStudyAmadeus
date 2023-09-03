package com.Amadeus.CaseStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Amadeus.CaseStudy.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@GetMapping(value = "/getToken")
	public String getToken() {

		String token = authService.generateToken();
		return token;
		
	}	
}
