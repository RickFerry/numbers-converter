package com.test.model;

public class RomanConverter {
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public int romanToArabic(String roman) {
        int result = 0;
        int i = 0;

        for (int j = 0; j < ROMAN_NUMERALS.length; j++) {
            while (roman.indexOf(ROMAN_NUMERALS[j], i) == i) {
                result += VALUES[j];
                i += ROMAN_NUMERALS[j].length();
            }
        }
        return result;
    }
}

