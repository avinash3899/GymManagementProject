package com.gym.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repo.CustomerRepo;
import com.gym.service.ResetPasswordService;

@Service
public class ResetPasswordServiceImplementation implements ResetPasswordService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Integer resetPassword(Customer updatedcustomer) {
		Customer actualCustomer = customerRepo.fetchCustomerByEmail(updatedcustomer.getEmail());
		if (actualCustomer.getDob().equals(updatedcustomer.getDob())) {
			actualCustomer.setPassword(updatedcustomer.getPassword());
			customerRepo.save(actualCustomer);
			return 1;
		} else {
			return 0;
		}
	}
}
