package com.billpay.service.impl;

import com.billpay.data.BillerWallet;
import com.billpay.repository.BillerWalletRepository;
import com.billpay.service.BillerWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillerWalletServiceImpl implements BillerWalletService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillerWalletServiceImpl.class);

    private BillerWalletRepository billerWalletRepository;

    @Autowired
    public BillerWalletServiceImpl(BillerWalletRepository billerWalletRepository) {
        this.billerWalletRepository = billerWalletRepository;
    }

    @Override
    public BillerWallet addMoney(BillerWallet billerWallet) {
        LOGGER.info("inside method addMoney");
        BillerWallet oldBillerWallet = billerWalletRepository.getBillerWalletByBillerId(billerWallet.getBillerId().getId());
        Double existingAmount = oldBillerWallet.getAmountCredit() !=null ? oldBillerWallet.getAmountCredit(): 0;
        billerWallet.setAmountCredit(billerWallet.getAmountCredit()+existingAmount);
        return billerWalletRepository.saveAndFlush(billerWallet);
    }

    @Override
    public BillerWallet getBillerWalletByBillerId(Integer billerId) {
        LOGGER.info("inside method getBillerWalletByBillerId");
        return billerWalletRepository.getBillerWalletByBillerId(billerId);
    }

    @Override
    public BillerWallet saveBillerWallet(BillerWallet billerWallet) {
        LOGGER.info("inside method saveBillerWallet");
        return billerWalletRepository.saveAndFlush(billerWallet);
    }
}
