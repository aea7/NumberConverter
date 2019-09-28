package com.numberconverter.services;

import com.numberconverter.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ConvertService {

    public String convert(Conversion conversionObject) throws IOException {
        return convertFormat(conversionObject.getFrom(), conversionObject.getTo(), conversionObject.getNumber());
    }

    private String convertFormat(String from, String to, String number) {
        switch (to) {
            case "Decimal":
                DecimalFormat df = new DecimalFormat();
                return df.convertToDecimal(from, number);
            case "Hexadecimal":
                HexadecimalFormat hf = new HexadecimalFormat(new RomanFormat(), new DecimalFormat());
                return hf.convertToHexadecimal(from, number);
            case "Binary":
                BinaryFormat bf = new BinaryFormat(new RomanFormat(), new DecimalFormat());
                return bf.convertToBinary(from, number);
            case "Roman":
                RomanFormat rf = new RomanFormat();
                return rf.convertToRoman(from, number);
            default:
                return "Invalid Format";
        }
    }

}
