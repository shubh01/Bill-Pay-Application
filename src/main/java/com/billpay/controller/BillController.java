package com.billpay.controller;

import com.billpay.data.UserBill;
import com.billpay.data.UserDetails;
import com.billpay.service.BillService;
import com.billpay.service.impl.UserWalletServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.billpay.service.UserDetailsService;

import java.util.List;

/**
 * @author Shubhashish Tiwari
 *
 */
@RestController
public class BillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillService billService;

    @RequestMapping(value = "getBill/{userId}",method = RequestMethod.GET)
    public ResponseEntity<List<UserBill>> getBill(@PathVariable("userId") Integer userId) {
        LOGGER.info("inside method getBill");
        return new ResponseEntity<>(billService.getBill(userId), HttpStatus.OK);
    }


    @RequestMapping(value = "payBill",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBill> payBill(@RequestBody UserBill userBill) {
        LOGGER.info("inside method payBill");
        return new ResponseEntity<>(billService.payBill(userBill), HttpStatus.OK);
    }


}
