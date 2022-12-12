package com.billpay.service;

import com.billpay.data.UserBill;
import com.billpay.repository.UserBillRepository;
import com.billpay.service.impl.UserBillServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserBillServiceImplTest {

    private UserBillServiceImpl userBillService;

    @Mock
    private UserBillRepository userBillRepository;

    @Before
    public void setUp(){
        userBillRepository = Mockito.mock(UserBillRepository.class);
        userBillService = new UserBillServiceImpl(userBillRepository);
    }

    @Test
    public void addAndSaveUserBillTest(){
        UserBill userBill = new UserBill();
        Mockito.when(userBillRepository.saveAndFlush(Mockito.any(UserBill.class))).thenReturn(userBill);
        userBill = userBillService.addAndSaveUserBill(userBill);
        Assert.assertEquals(userBill,userBill);
    }

    @Test
    public void getUserBillByUserIdTest(){
        List<UserBill> userBillList = new ArrayList<>();
        Mockito.when(userBillRepository.getUserBillByUserId(Mockito.any(Integer.class))).thenReturn(userBillList);
        List<UserBill> userBillList2 = userBillService.getUserBillByUserId(1);
        Assert.assertEquals(userBillList,userBillList2);
    }
}