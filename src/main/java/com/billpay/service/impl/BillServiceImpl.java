package com.billpay.service.impl;

import com.billpay.data.BillerWallet;
import com.billpay.data.UserBill;
import com.billpay.data.UserWallet;
import com.billpay.exception.BillPayException;
import com.billpay.service.BillService;
import com.billpay.service.BillerWalletService;
import com.billpay.service.UserBillService;
import com.billpay.service.UserWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceImpl.class);

    private UserBillService userBillService;
    private UserWalletService userWalletService;
    private BillerWalletService billerWalletService;
    private final static String INSUFFICIENT_FUND_MSG = "Insufficient funds in the wallet";

    @Autowired
    public BillServiceImpl(UserBillService userBillService, UserWalletService userWalletService, BillerWalletService billerWalletService) {
        this.userBillService = userBillService;
        this.userWalletService = userWalletService;
        this.billerWalletService = billerWalletService;
    }

    @Override
    public List<UserBill> getBill(Integer userId) {
        return userBillService.getUserBillByUserId(userId);
    }

    @Override
    public UserBill payBill(UserBill userBill) {
        LOGGER.info("inside method payBill");
        BillerWallet billerWallet = new BillerWallet();
        billerWallet.setBillerId(userBill.getBiller());
        UserWallet userWallet = userWalletService.getUserWalletByUserId(userBill.getUserDetails().getId());
        if(userWallet.getAmount() >= userBill.getDueAmount()){
            billerWallet.setAmountCredit(userBill.getDueAmount());
            billerWallet.setLastModified(new Date());
            billerWallet.setLastModifiedBy(userBill.getUserDetails());
            billerWalletService.addMoney(billerWallet);
            userWallet.setAction(UserWallet.Action.DEBIT);
            userWallet.setLastModified(new Date());
            userWallet.setAmount(userWallet.getAmount() - userBill.getDueAmount());
            userWalletService.saveUserWallet(userWallet);
            userBill.setDueAmount(0.0);
            userBill.setBillPaymentDate(new Date());
            return userBillService.addAndSaveUserBill(userBill);
        }
        throw new BillPayException(INSUFFICIENT_FUND_MSG);
    }
}
