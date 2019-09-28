package com.numberconverter.models;

public class BinaryFormat {

    private RomanFormat rf;
    private DecimalFormat df;

    public BinaryFormat(RomanFormat rf, DecimalFormat df){
        this.rf = rf;
        this.df = df;
    }

    public String convertToBinary(String sourceFormat, String numberRepresentation) {
        switch (sourceFormat) {
            case "Roman":
                return convertFromRomanToBinary(sourceFormat, numberRepresentation);
            case "Hexadecimal":
                return convertFromHexadecimalToBinary(numberRepresentation);
            case "Decimal":
                return convertFromDecimalToBinary(numberRepresentation);
            default:
                return "Invalid Format";
        }
    }

    private String convertFromRomanToBinary(String sourceFormat, String romanRepresentation) {
        return rf.convertToRoman("Decimal", df.convertToDecimal(sourceFormat, romanRepresentation));
    }

    private String convertFromDecimalToBinary(String decimalRepresentation) {
        return Integer.toBinaryString(Integer.parseInt(decimalRepresentation));
    }

    private String convertFromHexadecimalToBinary(String hexadecimalRepresentation) {
        return convertFromDecimalToBinary(Integer.toBinaryString(Integer.parseInt(hexadecimalRepresentation.trim(), 16)));
    }


}