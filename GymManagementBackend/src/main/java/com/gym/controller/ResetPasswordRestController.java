package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Customer;
import com.gym.service.ResetPasswordService;

@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://857a-59-91-88-30.ngrok.io")
public class ResetPasswordRestController {

	@Autowired
	ResetPasswordService resetPasswordService;

	@PostMapping("/resetPassword")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		ResponseEntity<String> response = null;
		try {
			Integer res = resetPasswordService.resetPassword(customer);
			if (res == 1)
				response = new ResponseEntity<String>("password changed", HttpStatus.OK);
			else
				response = new ResponseEntity<String>("wrong dob", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(e);
		}
		return response;
	}
}
