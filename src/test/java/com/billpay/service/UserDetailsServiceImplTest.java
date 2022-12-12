package com.billpay.service;

import com.billpay.data.UserDetails;
import com.billpay.exception.BillPayException;
import com.billpay.repository.UserDetailsRepository;
import com.billpay.service.impl.UserDetailsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserDetailsRepository userDetailsRepository;

    @Mock
    private UserWalletService userWalletService;

    private UserDetails userDetails;

    @Before
    public void setUp(){
        userDetails = new UserDetails();
        userDetailsService = new UserDetailsServiceImpl(userDetailsRepository,userWalletService);
    }

    @Test
    public void registerUser(){
        userDetails.setEmailId("john123@gmail.com");
        Mockito.when(userDetailsRepository.saveAndFlush(Mockito.any(UserDetails.class))).thenReturn(userDetails);
        userDetails = userDetailsService.registerUser(userDetails);
        Assert.assertNotNull(userDetails.getCreatedOn());
    }

    @Test(expected = BillPayException.class)
    public void registerUser1(){
        userDetails.setEmailId("john123gmail.com");
        userDetails = userDetailsService.registerUser(userDetails);
    }
}
