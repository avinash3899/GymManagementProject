package com.gym.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Contact;
import com.gym.repo.ContactRepo;
import com.gym.service.ContactService;

@Service
public class ContactServiceImplementation implements ContactService
{
	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public Integer saveMessage(Contact message) {
		contactRepo.save(message);
		return message.getId();
	}
	@Override
	public List<Contact> getAllMessages(){
		return contactRepo.findAll();
	}
	
	@Override
	public boolean isMessageExist(Integer id) {
		// TODO Auto-generated method stub
		return contactRepo.existsById(id);
	}

	@Override
	public void deleteMessage(Integer id) {
		// TODO Auto-generated method stub
		contactRepo.deleteById(id);
	}
}