package com.numberconverter.controllers;

import com.numberconverter.models.Conversion;
import com.numberconverter.services.ConvertService;
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

    @PostMapping("")
    @ApiOperation("Convert Number to new format")
    public String convert(@RequestBody Conversion conversionObject){
        try {
            return convertService.convert(conversionObject);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

}
