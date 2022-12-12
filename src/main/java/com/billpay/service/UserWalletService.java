package com.billpay.service;

import com.billpay.data.UserDetails;
import com.billpay.data.UserWallet;

public interface UserWalletService {
    public void createWallet(UserDetails userDetails);
    public UserWallet addMoney(Integer walletId, Double amount);
    public UserWallet getUserWalletByUserId(Integer userId);
    public UserWallet saveUserWallet(UserWallet userWallet);
}
