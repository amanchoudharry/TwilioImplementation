package com.twilioDemo.TWILIO.controller;

import com.twilioDemo.TWILIO.service.SOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sos")
public class SendSOSController {

    @Autowired
    private SOSService sosService;

    @PostMapping("/send")
    public String sendSOS(@RequestParam String phoneNumber) {
        return sosService.sendSOS(phoneNumber);
    }
}
