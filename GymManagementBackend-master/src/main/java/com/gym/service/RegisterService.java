package com.gym.service;

import java.util.List;

import com.gym.models.Customer;

public interface RegisterService {
	Integer createCustomer(Customer customer);
	List<Customer> getAllCustomer();
	boolean isCustomerExist(Integer id);
	void deleteCustomer(Integer id);
}
