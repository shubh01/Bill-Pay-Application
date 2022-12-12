package com.billpay.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsTest {

    private UserDetails userDetails;

    @Before
    public void setUp(){
        userDetails = new UserDetails();
        userDetails.setEmailId("xyz123@gmail.com");
        userDetails.setCreatedOn(new Date());
        userDetails.setId(1);
    }

    @Test
    public void test(){
        Assert.assertNotNull(userDetails.getCreatedOn());
        Assert.assertNotNull(userDetails.getId());
        Assert.assertNotNull(userDetails.getEmailId());
    }

}
