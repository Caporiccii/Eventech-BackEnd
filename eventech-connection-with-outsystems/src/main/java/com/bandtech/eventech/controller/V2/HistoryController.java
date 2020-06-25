package com.bandtech.eventech.controller.V2;

import com.bandtech.eventech.Service.V2.HistoryService;
import com.bandtech.eventech.model.V2.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/historys")
public class HistoryController {

    @Autowired
    private HistoryService service;
    private History history;

    @GetMapping
    public ResponseEntity getHistory(){
        history = service.addHistoryV2();
        if (history != null){
            return ok(history);
        }

       return badRequest().build();

    }
}
