package com.virtualschool.learning.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.virtualschool.learning.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OTPController {

    @Autowired
    OTPService otpService;

    private final String ACCOUNT_SID = "AC4b8d058131515888c5203b24525a842b";
    private final String AUTH_TOKEN = "71341ad39aadb707ae7890ac673b294f";

    @GetMapping(path="/api/otp/send/{mobileNumber}")
    public ResponseEntity<String> sendOtp(@PathVariable("mobileNumber") String number){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        int otp = otpService.generateOTP(number);
        Message message = Message.creator(new PhoneNumber(number),
                new PhoneNumber("+19892828529"),
                "OTP for verification is " + otp).create();
        return new ResponseEntity<>("OTP sent Successfully: " + message.getSid(), HttpStatus.OK);
    }

    @GetMapping(path="/api/otp/validate/{mobileNumber}")
    public ResponseEntity<String> sendOtp(@PathVariable("mobileNumber") String number, @RequestParam("otpNum") int otpNum){

        boolean isValidOtp = otpService.validateOtp(number, otpNum);

        return new ResponseEntity<>("OTP verification: " + isValidOtp, HttpStatus.OK);
    }
}
