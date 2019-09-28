package com.numberconverter.models;

import java.util.TreeMap;

public class RomanFormat {

    private TreeMap<Integer, String> romanNumberEquivalents = new TreeMap<Integer, String>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };

    public String convertToRoman(String sourceFormat, String numberRepresentation) {
        switch (sourceFormat) {
            case "Decimal":
                return convertFromDecimalToRoman(Integer.parseInt(numberRepresentation));
            case "Hexadecimal":
                return convertFromHexadecimalToRoman(numberRepresentation);
            case "Binary":
                return convertFromBinaryToRoman(numberRepresentation);
            default:
                return "Invalid Format";
        }
    }

    private String convertFromDecimalToRoman(int decimalNumber) {
        int biggestRomanNumber = romanNumberEquivalents.floorKey(decimalNumber);

        if (decimalNumber == biggestRomanNumber) {
            return romanNumberEquivalents.get(decimalNumber);
        }

        return romanNumberEquivalents.get(biggestRomanNumber) +
                convertFromDecimalToRoman(decimalNumber - biggestRomanNumber);
    }

    private String convertFromBinaryToRoman(String binaryRepresentation) {
        return convertFromDecimalToRoman(Integer.parseInt(binaryRepresentation.trim(), 2));
    }

    private String convertFromHexadecimalToRoman(String hexadecimalRepresentation) {
        return convertFromDecimalToRoman(Integer.parseInt(hexadecimalRepresentation.trim(), 16));
    }


}