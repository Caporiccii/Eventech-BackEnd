package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.HistoryOut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface IHistory {

    HistoryOut getForEntity(Long EventId);

}
