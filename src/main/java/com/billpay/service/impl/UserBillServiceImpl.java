package com.billpay.service.impl;

import com.billpay.data.UserBill;
import com.billpay.repository.UserBillRepository;
import com.billpay.service.UserBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBillServiceImpl implements UserBillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserBillServiceImpl.class);

    private UserBillRepository userBillRepository;

    @Autowired
    public UserBillServiceImpl(UserBillRepository userBillRepository) {
        this.userBillRepository = userBillRepository;
    }

    @Override
    public UserBill addAndSaveUserBill(UserBill userBill) {
        LOGGER.info("inside method addUserBill");
        return userBillRepository.saveAndFlush(userBill);
    }

    @Override
    public List<UserBill> getUserBillByUserId(Integer userId) {
        LOGGER.info("inside method getUserBillByUserId");
        return userBillRepository.getUserBillByUserId(userId);
    }
}
