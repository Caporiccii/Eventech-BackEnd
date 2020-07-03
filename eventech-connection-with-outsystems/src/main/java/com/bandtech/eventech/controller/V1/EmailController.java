package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.ServiceEmailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private ServiceEmailSend emailSend;

    @GetMapping("/{eventId}")
    public ResponseEntity sendEmail(@PathVariable("eventId") Long eventId){
        emailSend.sendEmail(eventId);
        return ResponseEntity.ok().build();
    }

}
