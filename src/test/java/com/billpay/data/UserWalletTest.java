package com.billpay.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class UserWalletTest {

    private UserWallet userWallet;
    private final static String REMARK = "test";

    @Before
    public void setUp(){
        userWallet = new UserWallet();
        userWallet.setAmount(1200.00);
        userWallet.setLastModified(new Date());
        userWallet.setId(1);
        userWallet.setUserDetails(new UserDetails());
        userWallet.setCreatedOn(new Date());
        userWallet.setRemark(REMARK);
        userWallet.setAction(UserWallet.Action.CREDIT);
    }

    @Test
    public void test1(){
        Assert.assertNotNull(userWallet.getId());
        Assert.assertNotNull(userWallet.getCreatedOn());
        Assert.assertNotNull(userWallet.getLastModified());
        Assert.assertNotNull(userWallet.getUserDetails());
        Assert.assertNotNull(userWallet.getAmount());
        Assert.assertNotNull(userWallet.getRemark());
        Assert.assertNotNull(userWallet.getAction());
    }
}
