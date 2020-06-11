package com.bandtech.eventech.controller.V2;

import com.bandtech.eventech.Service.ServiceEmailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/email")
public class EmailController {
    @Autowired
    private ServiceEmailSend emailSend;

    @PostMapping
    public ResponseEntity sendEmail(){
        emailSend.sendEmail();
        return ResponseEntity.ok().build();
    }

}
