package com.gym.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repo.CustomerRepo;
import com.gym.service.GetUserProfileService;

@Service
public class GetUserProfileServiceImplementation implements GetUserProfileService {

	@Autowired
	CustomerRepo customerRepo;
	
	public Customer fetchUserProfile(String email) {
		return customerRepo.fetchCustomerByEmail(email);
	}
	
	
}
