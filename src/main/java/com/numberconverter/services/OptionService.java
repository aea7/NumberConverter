package com.numberconverter.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OptionService {

    private ArrayList<String> options = new ArrayList<String>() {
        {
            add("Decimal");
            add("Hexadecimal");
            add("Roman");
            add("Binary");
        }
    };

    public List<String> returnAll() throws IOException {
        return options;
    }

}
