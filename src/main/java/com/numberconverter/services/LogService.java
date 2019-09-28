package com.numberconverter.services;

import com.numberconverter.models.Conversion;
import com.numberconverter.models.Log;
import com.numberconverter.repositories.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void createForConversion(boolean success, String response, Conversion conversionObject) {
        Log log = new Log();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
        log.setTimestamp(timestamp);
        log.setDescription("Converting "+ conversionObject.getNumber() + " " + conversionObject.getFrom()+
                " to: " + conversionObject.getTo());
        log.setRequest("POST Request: " + conversionObject.toString());
        if (success){
            log.setResponse("Success: " + response);
        }else {
            log.setResponse("Failed to convert");
        }
        logRepository.save(log);
    }

    public void createForOptions(boolean success, List<String> response) {
        Log log = new Log();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
        log.setTimestamp(timestamp);
        log.setDescription("Returning options ");
        log.setRequest("GET Request: ");
        if (success){
            System.out.println(response);
            log.setResponse("Success: " + response);
        }else {
            log.setResponse("Failed to return options");
        }
        logRepository.save(log);
    }

}
