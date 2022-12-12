package com.billpay.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BillerTest {

    private Biller biller;

    @Before
    public void setUp(){
        biller = new Biller();
        biller.setUtility(Biller.Utility.ELECTRICITY_BILL);
        biller.setId(1);
    }

    @Test
    public void test1(){
        Assert.assertNotNull(biller.getId());
        Assert.assertNotNull(biller.getUtility());
    }

}
