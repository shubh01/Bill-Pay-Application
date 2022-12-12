package com.billpay.service;

import com.billpay.data.UserBill;

import java.util.List;

public interface UserBillService {

    public UserBill addAndSaveUserBill(UserBill userBill);
    public List<UserBill> getUserBillByUserId(Integer userId);

}
