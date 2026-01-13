package com.lhapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhapi.dto.request.LoginRequest;
import com.lhapi.dto.response.LoginResponse;
import com.lhapi.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
// @CrossOrigin
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)
	{
		return ResponseEntity.ok(service.login(request));
	}

}
