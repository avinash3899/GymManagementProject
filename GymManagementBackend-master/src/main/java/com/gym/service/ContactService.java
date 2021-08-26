package com.gym.service;

import java.util.List;

import com.gym.models.Contact;

public interface ContactService
{
	Integer saveMessage(Contact message);
	List<Contact> getAllMessages();
	boolean isMessageExist(Integer id);
	void deleteMessage(Integer id);
}
