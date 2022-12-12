package com.billpay.service;

import com.billpay.data.UserDetails;
import com.billpay.data.UserWallet;
import com.billpay.repository.UserWalletRepository;
import com.billpay.service.impl.UserWalletServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserWalletServiceImplTest {

    private UserWalletServiceImpl userWalletService;

    @Mock
    private UserWalletRepository userWalletRepository;

    private UserDetails userDetails;

    @Before
    public void setUp(){
        userWalletRepository = Mockito.mock(UserWalletRepository.class);
        userDetails = new UserDetails();
        userDetails.setId(1);
        userWalletService = new UserWalletServiceImpl(userWalletRepository);
    }

    @Test
    public void createWalletTest(){
        Mockito.when(userWalletRepository.saveAndFlush(Mockito.any(UserWallet.class))).thenReturn(new UserWallet());
        userWalletService.createWallet(userDetails);
    }

    @Test
    public void addMoneyTest(){
        UserWallet userWallet = new UserWallet();
        userWallet.setAmount(200.0);
        Optional<UserWallet> userWalletOptinal = Optional.of(new UserWallet());
        Mockito.when(userWalletRepository.findById(Mockito.any(Integer.class))).thenReturn(userWalletOptinal);
        Mockito.when(userWalletRepository.saveAndFlush(Mockito.any(UserWallet.class))).thenReturn(userWallet);
        UserWallet userWallet1 = userWalletService.addMoney(1,200.0);
        Assert.assertEquals(new Double(200.0),userWallet1.getAmount());
    }

}
