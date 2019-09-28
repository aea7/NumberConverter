package com.numberconverter.controllers;

import com.numberconverter.models.Conversion;
import com.numberconverter.services.ConvertService;
import com.numberconverter.services.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/convert")
@Api("This is the conversion controller of the REST api")
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @Autowired
    private LogService logService;

    @PostMapping("")
    @ApiOperation("Convert Number to new format")
    public String convert(@RequestBody Conversion conversionObject){
        try {
            String response = convertService.convert(conversionObject);
            logService.createForConversion(true, response, conversionObject);
            return response;
        } catch (IOException e) {
            String response = e.getMessage();
            logService.createForConversion(false, response, conversionObject);
            return response;
        }
    }

}
