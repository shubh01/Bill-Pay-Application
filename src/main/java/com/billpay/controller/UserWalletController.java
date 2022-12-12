package com.billpay.controller;

import com.billpay.service.UserWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWalletController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserWalletController.class);

    @Autowired
    private UserWalletService userWalletService;

    private final static String MONEY_ADDED_SUCCESS = "Money added successfully";

    @RequestMapping(value = "addMoneyInWallet/{walletId}/{amount}",method = RequestMethod.PATCH)
    public ResponseEntity addMoneyInWallet(@PathVariable("walletId") Integer walletId, @PathVariable("amount") Double amount) {
        LOGGER.info("inside @method addMoneyInWallet");
        userWalletService.addMoney(walletId,amount);
        return new ResponseEntity<>(MONEY_ADDED_SUCCESS, HttpStatus.OK);
    }
}
