package com.billpay.service.impl;

import com.billpay.data.Biller;
import com.billpay.data.BillerWallet;
import com.billpay.data.UserBill;
import com.billpay.data.UserDetails;
import com.billpay.repository.BillerRepository;
import com.billpay.service.BillerWalletService;
import com.billpay.service.DataInjectorService;
import com.billpay.service.UserBillService;
import com.billpay.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataInjectorServiceServiceImpl implements DataInjectorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataInjectorServiceServiceImpl.class);

    @Autowired
    private BillerRepository billerRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserBillService userBillService;

    @Autowired
    private BillerWalletService billerWalletService;

    @Override
    public void injectStaticData(){
        LOGGER.info("inside method injectStaticData");
        List<UserDetails> userDetailsList = registerUsers();
        List<Biller> billerList = registerBiller();
        addUserBill(userDetailsList,billerList);
        registerBillerWallet(billerList);
    }

    private void registerBillerWallet(List<Biller> billerList){
        LOGGER.info("inside method registerBillerWallet");
        billerList.stream().forEach(e ->{
            BillerWallet billerWallet = new BillerWallet();
            billerWallet.setBillerId(e);
            billerWalletService.saveBillerWallet(billerWallet);
        });

    }

    private List<Biller> registerBiller() {
        LOGGER.info("inside method registerBiller");
        List<Biller> list = new ArrayList<>();
        Biller biller1 = new Biller();
        biller1.setId(1);
        biller1.setUtility(Biller.Utility.ELECTRICITY_BILL);
        Biller biller2 = new Biller();
        biller2.setId(2);
        biller2.setUtility(Biller.Utility.WIFI_BILL);
        Biller biller3 = new Biller();
        biller3.setId(3);
        biller3.setUtility(Biller.Utility.WATER_BILL);
        biller1 = billerRepository.saveAndFlush(biller1);
        biller2 = billerRepository.saveAndFlush(biller2);
        biller3 = billerRepository.saveAndFlush(biller3);
        list.add(biller1);
        list.add(biller2);
        list.add(biller3);
        return list;
    }


    private List<UserDetails> registerUsers(){
        LOGGER.info("inside method registerUsers");
        List<UserDetails> userDetailsList = new ArrayList<>();
        UserDetails userDetails1 = new UserDetails();
        userDetails1.setEmailId("john1@gmail.com");
        UserDetails userDetails2 = new UserDetails();
        userDetails2.setEmailId("ali2@gmail.com");
        UserDetails userDetails3 = new UserDetails();
        userDetails3.setEmailId("ken3@gmail.com");
        userDetails1 = userDetailsService.registerUser(userDetails1);
        userDetails2 = userDetailsService.registerUser(userDetails2);
        userDetails3 = userDetailsService.registerUser(userDetails3);
        userDetailsList.add(userDetails1);
        userDetailsList.add(userDetails2);
        userDetailsList.add(userDetails3);
        return userDetailsList;
    }

    private void addUserBill(List<UserDetails> userDetailsList, List<Biller> billerList){
        LOGGER.info("inside method addUserBill");
        UserBill userBill1 = new UserBill();
        userBill1.setUserDetails(userDetailsList.get(0));
        userBill1.setBillGenerationDate(new Date());
        userBill1.setDueAmount(500.0);
        userBill1.setBiller(billerList.get(0));

        UserBill userBill2 = new UserBill();
        userBill2.setUserDetails(userDetailsList.get(1));
        userBill2.setBillGenerationDate(new Date());
        userBill2.setDueAmount(1000.0);
        userBill2.setBiller(billerList.get(1));

        UserBill userBill3 = new UserBill();
        userBill3.setUserDetails(userDetailsList.get(2));
        userBill3.setBillGenerationDate(new Date());
        userBill3.setDueAmount(1500.0);
        userBill3.setBiller(billerList.get(2));

        UserBill userBill4 = new UserBill();
        userBill4.setUserDetails(userDetailsList.get(2));
        userBill4.setBillGenerationDate(new Date());
        userBill4.setDueAmount(2500.0);
        userBill4.setBiller(billerList.get(1));


        userBillService.addAndSaveUserBill(userBill1);
        userBillService.addAndSaveUserBill(userBill2);
        userBillService.addAndSaveUserBill(userBill3);
        userBillService.addAndSaveUserBill(userBill4);
    }

}
