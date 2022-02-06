package com.company.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Code works for numbers between 1 and 3999
public class Converter {
    private static Map<String, Integer> romanMap;
    private static Map<Integer, String> arabicMap;
    private String[] roman;
    private int[] arabic;

    private void initializeArrays(){
        arabic = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    }

    public Converter() {
        romanMap = new HashMap<String, Integer>();
        arabicMap = new HashMap<>();
        initializeArrays();
        for(int i = 0; i < roman.length; i++){
            romanMap.put(roman[i], arabic[i]);
            arabicMap.put(arabic[i], roman[i]);
        }
    }

    //Method returns (int) arabic number given a (String) roman number
    public static int romanToArabic(String num){
        int result = 0;
        String current, next;
        for(int i = 0; i < num.length(); i++){
            current = String.valueOf(num.charAt(i));
            if(i < num.length()-1){
                next = String.valueOf(num.charAt(i+1));
                if(romanMap.get(current) < romanMap.get(next)){
                    result += romanMap.get(current + next);
                    i++;
                }
                else{
                    result += romanMap.get(current);
                }
            }
            else result += romanMap.get(current);
        }
        return result;
    }

    //Method returns (String) roman number given a (int) arabic number
    public static String arabicToRoman(int num){
        String numInString = String.valueOf(num);
        List<Integer> numsInArabic = new ArrayList<>();
        StringBuilder resultInRoman = new StringBuilder();

        //Dividing number to units
        int power, digit, number, j = 0;
        for(int i = numInString.length()-1; i >= 0; i--){
            power = (int)Math.pow(10, i);
            digit = Integer.parseInt(String.valueOf(numInString.charAt(j++)));
            number = digit * power;
            numsInArabic.add(number);
        }

        int firstDigit, dividedNum, getPower, minus = 0;
        for(int numInArabic : numsInArabic){
            //if the numInArabic is already in the map
            if(arabicMap.containsKey(numInArabic)){
                resultInRoman.append("").append(arabicMap.get(numInArabic));
            }
            //if the numInArabic is multiple of another number
            else{
                if(numInArabic == 0) continue;
                firstDigit = Integer.parseInt(String.valueOf(String.valueOf(numInArabic).charAt(0)));
                if(firstDigit > 5){
                    getPower = (int)Math.pow(10, String.valueOf(numInArabic).length()-1);
                    resultInRoman.append(arabicMap.get(5 * getPower));
                    minus = 5;
                }

                dividedNum = numInArabic / firstDigit;
                for(int i = 0; i < firstDigit - minus; i++){
                    resultInRoman.append("").append(arabicMap.get(dividedNum));
                }
            }
            minus = 0;
        }
        return resultInRoman.toString();
    }
}
