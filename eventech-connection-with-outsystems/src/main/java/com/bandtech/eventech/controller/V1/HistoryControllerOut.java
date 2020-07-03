package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.HistoryServiceOut;
import com.bandtech.eventech.model.V1.HistoryOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("historys-out")
public class HistoryControllerOut {

    @Autowired
    private HistoryServiceOut service;
    private HistoryOut history;

    @GetMapping("/{EventId}")
    public ResponseEntity getHistory(@PathVariable("EventId") Long EventId){
        history = service.createHistory(EventId);

        if (history != null) {
            return  ok(history);
        }

        return notFound().build();
    }

}
