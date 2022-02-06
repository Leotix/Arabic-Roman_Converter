package com.company.converter;

import java.util.Scanner;

//Class for user to test the class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        int arabicNum;

        //Getting input from user
        System.out.print("Type in arabic number: ");
        arabicNum = scanner.nextInt();

        //Converting to roman
        String roman = Converter.arabicToRoman(arabicNum);

        //Converting back to arabic
        int arabic = Converter.romanToArabic(roman);

        //Numbers calculated by Converter
        System.out.println(roman);
        System.out.println(arabic);
    }
}
