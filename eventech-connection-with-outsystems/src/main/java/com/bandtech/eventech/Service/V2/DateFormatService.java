package com.bandtech.eventech.Service.V2;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateFormatService {
    LocalDateTime now;
    DateTimeFormatter dateHour;
    String formattedDate;

    public String formatDate(){
        now =  LocalDateTime.now();
        dateHour = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate = now.format(dateHour);

        return formattedDate;
    }
}
