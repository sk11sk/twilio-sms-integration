package com.twiliosms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    public void sendSms(String to, String message) {
        Twilio.init(accountSid, authToken);

        Message twilioMessage = Message.creator(
                        new com.twilio.type.PhoneNumber(to),
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        message)
                .create();

        System.out.println("SMS sent with SID: " + twilioMessage.getSid());
    }
}
