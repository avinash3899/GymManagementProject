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

import com.gym.models.Contact;
import com.gym.service.ContactService;

@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://857a-59-91-88-30.ngrok.io")
public class ContactRestController 
{
	@Autowired
	ContactService contactService;
	
	@PostMapping("/sendMessage")
	public ResponseEntity<String> createContact(@RequestBody Contact contact){
		ResponseEntity<String> response = null;
		try {
			Integer id = contactService.saveMessage(contact);
			String body = "Contact '"+id+"' created";
			response = new ResponseEntity<String>(body,	HttpStatus.CREATED);
		}
		catch (Exception e) {
			response =  new ResponseEntity<String>("Unable to Create Contact",HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(e);
		}
		return response;
	}
	
	@GetMapping("/allmessages")
	public ResponseEntity<?> getAllMessages(){
		List<Contact> allmessages = contactService.getAllMessages();
		ResponseEntity<?> resp = null ;
		try {
			
			if(allmessages!=null && !allmessages.isEmpty()) {
				allmessages.sort((s1,s2)->s1.getEmail().compareTo(s2.getEmail()));
				resp = new ResponseEntity<List<Contact>>(allmessages, HttpStatus.OK);
			}else {
				
				resp = null;
			}
		}catch (Exception e) {
			resp =  new ResponseEntity<String>("Unable to Fetch Customer",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	
	@DeleteMapping("/removeMessage/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable Integer id)
	{
		ResponseEntity<String> resp = null;

		try {
			boolean exist = contactService.isMessageExist(id);
			if(exist) {
				contactService.deleteMessage(id);
				resp = new ResponseEntity<String>("Message '"+id+"' deleted",HttpStatus.OK);
			}
			else {
				
				resp = new ResponseEntity<String>("Message '"+id+"' not exist",HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to delete",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}
