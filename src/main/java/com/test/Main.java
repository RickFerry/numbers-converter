package com.test;

import com.test.model.ArabicConverter;
import com.test.model.RomanConverter;

public class Main {
    public static void main(String[] args) {
        RomanConverter romanConverter = new RomanConverter();
        ArabicConverter arabicConverter = new ArabicConverter();

        // romano para arábico
        String romanNumber = "MCMXCIV"; // 1994
        int arabicNumber = romanConverter.romanToArabic(romanNumber);
        System.out.println("Roman " + romanNumber + " to Arabic is " + arabicNumber);

        // arábico para romano
        int number = 1994;
        String romanResult = arabicConverter.arabicToRoman(number);
        System.out.println("Arabic " + number + " to Roman is " + romanResult);
    }
}