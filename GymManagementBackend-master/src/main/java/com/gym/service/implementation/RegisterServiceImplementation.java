package com.gym.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repo.CustomerRepo;
import com.gym.service.RegisterService;

@Service
public class RegisterServiceImplementation implements RegisterService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Integer createCustomer(Customer customer) {
		customer.setIsAdmin("no");
		customer.setSubscription("None");
		customerRepo.save(customer);
		return customer.getId();
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public boolean isCustomerExist(Integer id) {
		// TODO Auto-generated method stub
		return customerRepo.existsById(id);
	}

	@Override
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(id);
	}
	
}
