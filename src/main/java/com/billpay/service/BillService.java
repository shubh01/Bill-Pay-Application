package com.billpay.service;

import com.billpay.data.UserBill;

import java.util.List;

public interface BillService {

    public List<UserBill> getBill(Integer userId);

    public UserBill payBill(UserBill userBill);

}
