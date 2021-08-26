package com.gym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.service.LoginService;


@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://857a-59-91-88-30.ngrok.io")
public class LoginCustomerRestController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/loginvalidate/{email}/{password}")
	public ResponseEntity<String[]> loginValidate(@PathVariable String email, @PathVariable String password){
		ResponseEntity<String[]> response = null;
		try {
			String[] message =loginService.loginvalidate(email, password);
			response = new ResponseEntity<String[]>(message, HttpStatus.OK);
		} catch (Exception e) {
			//response = new ResponseEntity<String[]>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
