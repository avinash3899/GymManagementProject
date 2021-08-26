package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gym.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Transactional
	@Query(value="SELECT * FROM Gym_Customers  where email = ?1",nativeQuery=true)
	public Customer fetchCustomerByEmail(String email);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update Gym_Customers set subscription =?2 where email =?1",nativeQuery=true)
	public Integer updateSubscription( String email, String subscription);

}
