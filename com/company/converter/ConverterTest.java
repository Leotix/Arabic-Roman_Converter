package com.company.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConverterTest {
    /* Testing Converter back and forth
    * Firstly, converting arabic numbers to roman with Converter's method
    * Then, converting it back to arabic numbers with another Converter's method
    * Converter should work properly for numbers between 1 and 3999
    * */
    private static Converter converter;
    @BeforeAll
    static void setUp() {
        converter = new Converter();
    }

    @Test
    public void converterClassTestBackAndForth(){
        int[] arabicExpectedArray = new int[3999];
        int[] arabicResultArray = new int[3999];
        String[] romanResultArray = new String[3999];
        for(int i = 1; i <= 3999; i++){
            arabicExpectedArray[i-1] = i;
            romanResultArray[i-1] = converter.arabicToRoman(i);
            arabicResultArray[i-1] = converter.romanToArabic(romanResultArray[i-1]);
            System.out.println(arabicResultArray[i-1] + " = " + romanResultArray[i-1]);
        }
        Assertions.assertArrayEquals(arabicExpectedArray, arabicResultArray);
    }
}