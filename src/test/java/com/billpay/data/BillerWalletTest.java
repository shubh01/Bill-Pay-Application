package com.billpay.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class BillerWalletTest {

    private BillerWallet billerWallet;

    @Before
    public void setUp(){
        billerWallet = new BillerWallet();
        billerWallet.setBillerId(new Biller());
        billerWallet.setLastModifiedBy(new UserDetails());
        billerWallet.setLastModified(new Date());
        billerWallet.setAmountCredit(20.0);
        billerWallet.setId(1);
    }

    @Test
    public void test1(){
        Assert.assertNotNull(billerWallet.getBillerId());
        Assert.assertNotNull(billerWallet.getId());
        Assert.assertNotNull(billerWallet.getAmountCredit());
        Assert.assertNotNull(billerWallet.getLastModified());
        Assert.assertNotNull(billerWallet.getLastModifiedBy());
    }
}
