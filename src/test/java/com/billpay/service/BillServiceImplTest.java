package com.billpay.service;

import com.billpay.data.BillerWallet;
import com.billpay.data.UserBill;
import com.billpay.data.UserDetails;
import com.billpay.data.UserWallet;
import com.billpay.service.impl.BillServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceImplTest {

    private BillServiceImpl billServiceImpl;

    @Mock
    private UserBillService userBillService;
    @Mock
    private UserWalletService userWalletService;
    @Mock
    private BillerWalletService billerWalletService;

    @Before
    public void setup(){
        userBillService = Mockito.mock(UserBillService.class);
        userWalletService = Mockito.mock(UserWalletService.class);
        billerWalletService = Mockito.mock(BillerWalletService.class);
        billServiceImpl = new BillServiceImpl(userBillService,userWalletService,billerWalletService);
    }

    @Test
    public void getBillTest(){
        List<UserBill> userBillList = new ArrayList<>();
        Mockito.when(userBillService.getUserBillByUserId(Mockito.any(Integer.class))).thenReturn(userBillList);
        List<UserBill> userBillList1 = billServiceImpl.getBill(1);
        Assert.assertEquals(userBillList1,userBillList);
    }

    @Test
    public void payBillTest(){
        UserBill userBill = new UserBill();
        UserDetails userDetails = new UserDetails();
        userDetails.setId(1);
        userBill.setUserDetails(userDetails);
        userBill.setDueAmount(500.00);
        UserWallet userWallet = new UserWallet();
        userWallet.setAmount(1000.0);
        Mockito.when(userWalletService.getUserWalletByUserId(Mockito.any(Integer.class))).thenReturn(userWallet);
        Mockito.when(billerWalletService.addMoney(Mockito.any(BillerWallet.class))).thenReturn(new BillerWallet());
        Mockito.when(userWalletService.saveUserWallet(Mockito.any(UserWallet.class))).thenReturn(new UserWallet());
        Mockito.when(userBillService.addAndSaveUserBill(Mockito.any(UserBill.class))).thenReturn(userBill);
        userBill = billServiceImpl.payBill(userBill);
        Assert.assertEquals(new Double(0.0),userBill.getDueAmount());
    }

}
