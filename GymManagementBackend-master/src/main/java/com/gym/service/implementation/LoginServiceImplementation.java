package com.gym.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repo.CustomerRepo;
import com.gym.service.LoginService;

@Service
public class LoginServiceImplementation implements LoginService {
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String[] loginvalidate(String email, String password) {
		Customer customer = customerRepo.fetchCustomerByEmail(email);
		String[] reply = new String[3];
		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				reply[0] = "success";
				reply[1] = customer.getFirstName();
				reply[2] = customer.getIsAdmin();
				return reply;
			} else {
				reply[0] = "wrongPassword";
				return reply;
			}
		} else {
			reply[0] = "invalidEmail";
			return reply;
		}
	}
}
