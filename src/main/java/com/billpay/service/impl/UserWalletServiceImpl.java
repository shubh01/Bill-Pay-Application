package com.billpay.service.impl;

import com.billpay.data.UserDetails;
import com.billpay.data.UserWallet;
import com.billpay.exception.BillPayException;
import com.billpay.repository.UserDetailsRepository;
import com.billpay.repository.UserWalletRepository;
import com.billpay.service.UserWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserWalletServiceImpl.class);

    private UserWalletRepository userWalletRepository;

    @Autowired
    public UserWalletServiceImpl(UserWalletRepository userWalletRepository) {
        this.userWalletRepository = userWalletRepository;
    }

    @Override
    public void createWallet(UserDetails userDetails) {
        LOGGER.info("inside method createWallet");
        UserWallet userWallet = new UserWallet();
        userWallet.setCreatedOn(new Date());
        userWallet.setUserDetails(userDetails);
        userWallet.setAmount(1000.00);
        userWalletRepository.saveAndFlush(userWallet);
    }

    @Override
    public UserWallet addMoney(Integer walletId, Double amount){
        LOGGER.info("inside method addMoney");
        try {
            UserWallet userWallet = userWalletRepository.findById(walletId).get();
            Double existingAmout = userWallet.getAmount() == null ? 0 : userWallet.getAmount();
            userWallet.setAmount(existingAmout + amount);
            userWallet.setAction(UserWallet.Action.CREDIT);
            userWallet.setLastModified(new Date());
            return userWalletRepository.saveAndFlush(userWallet);
        }catch (Exception e){
            LOGGER.info("exception occurred inside method addMoney",e);
            throw new BillPayException(e.getMessage());
        }
    }

    @Override
    public UserWallet getUserWalletByUserId(Integer userId) {
        LOGGER.info("inside method getUserWalletByUserId");
        return userWalletRepository.getUserWalletByUserId(userId);
    }

    @Override
    public UserWallet saveUserWallet(UserWallet userWallet) {
        LOGGER.info("inside method saveUserWallet");
        return userWalletRepository.saveAndFlush(userWallet);
    }

}
