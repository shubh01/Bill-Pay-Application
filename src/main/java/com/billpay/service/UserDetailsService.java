package com.billpay.service;

import com.billpay.data.UserDetails;

/**
 * @author Shubhashish Tiwari
 *
 */
public interface UserDetailsService {

	public UserDetails registerUser(UserDetails userDetails);
	
}
