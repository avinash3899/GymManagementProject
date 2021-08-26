package com.gym.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.repo.CustomerRepo;
import com.gym.service.UpdateSubscriptionService;

@Service
public class UpdateSubscriptionServiceImplementation implements UpdateSubscriptionService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public String updateSubscription(String email,String subscription) {
		Integer response = customerRepo.updateSubscription(email, subscription);
		System.out.println(response);
		return "success";
	}
}
