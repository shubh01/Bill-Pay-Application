package com.billpay.service;

import com.billpay.data.BillerWallet;

public interface BillerWalletService {

    public BillerWallet addMoney(BillerWallet billerWallet);
    public BillerWallet getBillerWalletByBillerId(Integer billerId);
    public BillerWallet saveBillerWallet(BillerWallet billerWallet);

}
