package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.service.UpdateSubscriptionService;

@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://857a-59-91-88-30.ngrok.io")
public class UpdateSubscriptionRestController {

	@Autowired
	UpdateSubscriptionService updateSubscriptionService;
	
	@PutMapping("/updateSubscription/{email}")
	public ResponseEntity<String> updateSubscription(@PathVariable String email,@RequestBody String subscription
			)
	{
		ResponseEntity<String> resp =null;
		try {
			String response = updateSubscriptionService.updateSubscription(email, subscription);
			resp = new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.toString(), HttpStatus.OK);
		}
		return resp;
	}
	
	
}
