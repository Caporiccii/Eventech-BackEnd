package com.bandtech.eventech.controller.V3;

import com.bandtech.eventech.Service.V3.SendEmailServiceForMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/email")
public class EmailControllerForMobile {
    @Autowired
    private SendEmailServiceForMobile sendEmailServiceForMobile;

    @GetMapping("/{eventId}")
    public ResponseEntity sendEmail(@PathVariable("eventId") Integer eventId){
        sendEmailServiceForMobile.sendEmail(eventId);
        return ResponseEntity.ok().build();
    }

}
