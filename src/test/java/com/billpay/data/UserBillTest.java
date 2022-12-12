package com.billpay.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class UserBillTest {

    private UserBill userBill;

    @Before
    public void setUp(){
        userBill = new UserBill();
        userBill.setBillPaymentDate(new Date());
        userBill.setUserDetails(new UserDetails());
        userBill.setDueAmount(500.0);
        userBill.setId(1);
        userBill.setBiller(new Biller());
        userBill.setBillGenerationDate(new Date());
    }

    @Test
    public void test1(){
        Assert.assertNotNull(userBill.getId());
        Assert.assertNotNull(userBill.getBiller());
        Assert.assertNotNull(userBill.getUserDetails());
        Assert.assertNotNull(userBill.getBillGenerationDate());
        Assert.assertNotNull(userBill.getBillPaymentDate());
        Assert.assertNotNull(userBill.getDueAmount());
    }


}
