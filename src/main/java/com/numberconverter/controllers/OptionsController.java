package com.numberconverter.controllers;

import com.numberconverter.services.LogService;
import com.numberconverter.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/option")
@Api("This is the option controller of the REST api")
public class OptionsController {

    @Autowired
    private OptionService optionService;

    @Autowired
    private LogService logService;

    @GetMapping("")
    @ApiOperation("Listing all options")
    public List<String> findAll() throws IOException {
        List<String> response = optionService.returnAll();

        if (response.size() < 1){
            logService.createForOptions(false, response);
        }else {
            logService.createForOptions(true, response);
        }

        return response;
    }

}

