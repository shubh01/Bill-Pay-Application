package com.billpay.exception;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BillPayExceptionTest {

    private BillPayException billPayException;

    @Before
    public void setUp(){
        billPayException = new BillPayException();
    }

    @Test
    public void test1(){
        billPayException.setErrorMessage("test error message");
        Assert.assertNotNull(billPayException.getErrorMessage());
    }

    @Test
    public void test2(){
        billPayException = new BillPayException("test error message");
        Assert.assertNotNull(billPayException.getErrorMessage());
    }

}

