package com.test.model;

public class ArabicConverter {
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String arabicToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number out of range (1-3999)");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                result.append(ROMAN_NUMERALS[i]);
                number -= VALUES[i];
            }
        }
        return result.toString();
    }
}

