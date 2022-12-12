package com.billpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billpay.data.UserDetails;

/**
 * @author Shubhashish Tiwari
 *
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

}
