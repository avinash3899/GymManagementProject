package com.gym.service;

import com.gym.models.Customer;

public interface GetUserProfileService {

	Customer fetchUserProfile(String email);
	
}
