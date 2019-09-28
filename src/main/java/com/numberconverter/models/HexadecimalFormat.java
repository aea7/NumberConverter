package com.numberconverter.models;

public class HexadecimalFormat {

    private RomanFormat rf;
    private DecimalFormat df;

    public HexadecimalFormat(RomanFormat rf, DecimalFormat df){
        this.rf = rf;
        this.df = df;
    }

    public String convertToHexadecimal(String sourceFormat, String numberRepresentation) {
        switch (sourceFormat) {
            case "Hexadecimal":
                return convertFromRomanToHexadecimal(sourceFormat, numberRepresentation);
            case "Binary":
                return convertFromBinaryToHexadecimal(numberRepresentation);
            case "Decimal":
                return convertFromDecimalToHexadecimal(numberRepresentation);
            default:
                return "Invalid Format";
        }
    }

    private String convertFromRomanToHexadecimal(String sourceFormat, String romanRepresentation) {
        return rf.convertToRoman("Decimal", df.convertToDecimal(sourceFormat, romanRepresentation));
    }

    private String convertFromBinaryToHexadecimal(String binaryRepresentation) {
        return convertFromDecimalToHexadecimal(String.valueOf(Integer.parseInt(binaryRepresentation.trim(), 2)));
    }

    private String convertFromDecimalToHexadecimal(String decimalRepresentation) {
        return Integer.toHexString(Integer.parseInt(decimalRepresentation.trim()));
    }

}