package com.bandtech.eventech.controller.V2;

import com.bandtech.eventech.Service.V2.HistoryService;
import com.bandtech.eventech.model.V2.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/historys")
public class HistoryController {

    @Autowired
    private HistoryService service;
    private History history;

    @GetMapping
    public ResponseEntity getHistory(){
        history = service.addHistory();
        if (history != null){
            return ResponseEntity.ok(history);
        }

       return ResponseEntity.badRequest().build();

    }
}
