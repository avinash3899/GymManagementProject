package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Customer;
import com.gym.service.RegisterService;

@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://857a-59-91-88-30.ngrok.io")
public class RegisterCustomerRestController {
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
		ResponseEntity<String> response = null;
		try {
			Integer id = registerService.createCustomer(customer);
			String body = "Customer '"+id+"' created";
			response = new ResponseEntity<String>(body,	HttpStatus.CREATED);
		}
		catch (Exception e) {
			response =  new ResponseEntity<String>("Unable to Create Student",HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(e);
		}
		return response;
	}
	
	@GetMapping("/allcustomer")
	public ResponseEntity<?> getAllCustomer()
	{
		List <Customer> list = registerService.getAllCustomer();
		ResponseEntity<?> resp = null ;
		try {
			
			if(list!=null && !list.isEmpty()) {
				list.sort((s1,s2)->s1.getFirstName().compareTo(s2.getFirstName()));
				resp = new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
			}else {
				
				resp = new ResponseEntity<String>("No Customer Found",HttpStatus.OK);
			}
		}catch (Exception e) {
			resp =  new ResponseEntity<String>("Unable to Fetch Customer",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		
		
		return resp;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable Integer id)
	{
		ResponseEntity<String> resp = null;

		try {
			boolean exist = registerService.isCustomerExist(id);
			if(exist) {
				registerService.deleteCustomer(id);
				resp = new ResponseEntity<String>("Customer '"+id+"' deleted",HttpStatus.OK);
			}
			else {
				
				resp = new ResponseEntity<String>("Customer '"+id+"' not exist",HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to delete",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
}
