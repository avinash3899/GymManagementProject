package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.models.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>
{
	
}