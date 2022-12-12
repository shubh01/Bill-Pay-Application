package com.billpay.controller;

import com.billpay.data.UserDetails;
import com.billpay.service.UserDetailsService;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsController.class);

    @Autowired
    private UserDetailsService userDetailsService;

    private final static String USER_REGISTER_SUCCESS = "user registered successfully";

    @RequestMapping(value = "registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@NotNull  @RequestBody UserDetails userDetails) {
        LOGGER.info("inside @method registerUser");
        userDetailsService.registerUser(userDetails);
        return new ResponseEntity<>(USER_REGISTER_SUCCESS, HttpStatus.CREATED);
    }
}
