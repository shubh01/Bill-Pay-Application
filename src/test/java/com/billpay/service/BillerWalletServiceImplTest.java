package com.billpay.service;

import com.billpay.data.Biller;
import com.billpay.data.BillerWallet;
import com.billpay.repository.BillerWalletRepository;
import com.billpay.service.impl.BillerWalletServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BillerWalletServiceImplTest {

    private BillerWalletServiceImpl billerWalletService;

    @Mock
    private BillerWalletRepository billerWalletRepository;

    private BillerWallet billerWallet;

    @Before
    public void setUp(){
        billerWalletRepository = Mockito.mock(BillerWalletRepository.class);
        billerWalletService = new BillerWalletServiceImpl(billerWalletRepository);
        getBillerWallet();
    }

    private void getBillerWallet() {
        Biller biller = new Biller();
        biller.setId(1);
        billerWallet = new BillerWallet();
        billerWallet.setBillerId(biller);
        billerWallet.setAmountCredit(20.0);
    }

    @Test
    public void addMoneyTest(){
        BillerWallet oldWallet = new BillerWallet();
        oldWallet.setAmountCredit(20.0);
        Mockito.when(billerWalletRepository.getBillerWalletByBillerId(Mockito.any(Integer.class))).thenReturn(oldWallet);
        Mockito.when(billerWalletRepository.saveAndFlush(Mockito.any(BillerWallet.class))).thenReturn(billerWallet);
        billerWallet = billerWalletService.addMoney(billerWallet);
        Assert.assertEquals(new Double(40.0),billerWallet.getAmountCredit());
    }

    @Test
    public void getBillerWalletByBillerIdTest(){
        Mockito.when(billerWalletRepository.getBillerWalletByBillerId(Mockito.any(Integer.class))).thenReturn(billerWallet);
        billerWallet = billerWalletService.getBillerWalletByBillerId(1);
        Assert.assertEquals(billerWallet,billerWallet);
    }

    @Test
    public void saveBillerWalletTest(){
        Mockito.when(billerWalletRepository.saveAndFlush(Mockito.any(BillerWallet.class))).thenReturn(billerWallet);
        billerWallet = billerWalletService.saveBillerWallet(billerWallet);
        Assert.assertEquals(billerWallet,billerWallet);
    }
}
