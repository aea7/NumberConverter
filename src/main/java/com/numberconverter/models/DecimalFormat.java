package com.numberconverter.models;

public class DecimalFormat {

    public String convertToDecimal(String sourceFormat, String numberRepresentation) {
        switch (sourceFormat) {
            case "Roman":
                return convertFromRomanToDecimal(numberRepresentation);
            case "Hexadecimal":
                return convertFromHexadecimalToDecimal(numberRepresentation);
            case "Binary":
                return convertFromBinaryToDecimal(numberRepresentation);
            default:
                return "Invalid Format";
        }
    }

    private String convertFromRomanToDecimal(String romanNumber) {
        int result = 0;
        String tempRomanString = romanNumber + " ";
        for (int i = 0; i < romanNumber.length(); i++) {
            char ch = tempRomanString.charAt(i);
            char nextChar = tempRomanString.charAt(i + 1);

            if (ch == 'M') {
                result += 1000;
            } else if (ch == 'C') {
                if (nextChar == 'M') {
                    result += 900;
                    i++;
                } else if (nextChar == 'D') {
                    result += 400;
                    i++;
                } else {
                    result += 100;
                }
            } else if (ch == 'D') {
                result += 500;
            } else if (ch == 'X') {
                if (nextChar == 'C') {
                    result += 90;
                    i++;
                } else if (nextChar == 'L') {
                    result += 40;
                    i++;
                } else {
                    result += 10;
                }
            } else if (ch == 'L') {
                result += 50;
            } else if (ch == 'V') {
                result += 5;
            } else if (ch == 'I') {
                if (nextChar == 'X') {
                    result += 9;
                    i++;
                } else if (nextChar == 'V') {
                    result += 4;
                    i++;
                } else {
                    result += 1;
                }
            }
        }
        return String.valueOf(result);
    }

    public String convertFromBinaryToDecimal(String binaryRepresentation){
        return String.valueOf(Integer.parseInt(binaryRepresentation.trim(), 2));
    }

    public String convertFromHexadecimalToDecimal(String hexadecimalRepresentation){
        return String.valueOf(Integer.parseInt(hexadecimalRepresentation.trim(), 16));
    }

}