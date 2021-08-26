package com.gym.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Customer;
import com.gym.service.GetUserProfileService;

@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://857a-59-91-88-30.ngrok.io")
public class GetUserProfileRestController {

	@Autowired
	GetUserProfileService getUserProfileService;
	
	@GetMapping("/getUserProfile/{email}")
	public ResponseEntity<Customer> getUserProfile(@PathVariable String email)
	{
		ResponseEntity<Customer> profile = null ;
		try {
			Customer customer = getUserProfileService.fetchUserProfile(email);
			System.out.println(customer.getFirstName());
			profile = new ResponseEntity<Customer>(customer, HttpStatus.OK);
			return profile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
	}
	
}
