package com.billpay.service.impl;

import com.billpay.exception.BillPayException;
import com.billpay.service.UserWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.billpay.data.UserDetails;
import com.billpay.repository.UserDetailsRepository;
import com.billpay.service.UserDetailsService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;

import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author Shubhashish Tiwari
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private UserDetailsRepository userDetailsRepository;

	private UserWalletService userWalletService;

	@Autowired
	public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserWalletService userWalletService) {
		this.userDetailsRepository = userDetailsRepository;
		this.userWalletService = userWalletService;
	}

	private final String EMAIL_REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * @param userDetails
	 * @return
	 */
	public UserDetails registerUser(UserDetails userDetails) {
		LOGGER.info("inside method registerUser");
		if(userDetails !=null && userDetails.getEmailId() !=null && isEmailIdValid(userDetails.getEmailId())){
			userDetails.setCreatedOn(new Date());
			try{
				userDetails = userDetailsRepository.saveAndFlush(userDetails);
			}catch (DataIntegrityViolationException e){
				LOGGER.error("exception occurred @method registerUser",e);
				throw new BillPayException("duplicate email id");
			}catch (Exception e){
				LOGGER.error("exception occurred @method registerUser",e);
				throw new BillPayException(e.getMessage());
			}
			userWalletService.createWallet(userDetails);
			return userDetails;
		}
		throw new BillPayException("Invalid email id");
	}

	/**
	 *
	 * @param emailId
	 * @return
	 */
	private  Boolean isEmailIdValid(String emailId){
		LOGGER.info("inside method isEmailIdValid emailId: "+emailId);
		return Pattern.matches(EMAIL_REGEX_PATTERN,emailId);
	}
}
