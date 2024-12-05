package com.twilioDemo.TWILIO.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SOSService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public String sendSOS(String recipientPhoneNumber) {
        try {
            String messageBody = "SOS! You are my Emergency Contact and I have an emergency Please assist immediately.";
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber(recipientPhoneNumber),
                    new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                    messageBody
            ).create();

            return "SOS sent successfully! Message SID: " + message.getSid();
        } catch (Exception e) {
            return "Failed to send SOS: " + e.getMessage();
        }
    }

}
