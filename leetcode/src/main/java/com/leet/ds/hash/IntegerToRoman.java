package com.leet.ds.hash;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {


    public static void main(String[] args) {
        int[] inputs = {3, 4, 9, 58, 1994, 450};
        String[] outputs = {"III", "IV", "IX", "LVIII", "MCMXCIV", "CDL"};
        IntegerToRoman integerToRoman = new IntegerToRoman();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + inputs[i] );
            System.out.println("Output : " + integerToRoman.intToRoman(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("##########################################");
        }
    }

    private Map<Integer, String> mapping = new HashMap<>();

    {
        mapping.put(1000, "M");
        mapping.put(900, "CM");
        mapping.put(500, "D");
        mapping.put(400, "CD");
        mapping.put(100, "C");
        mapping.put(90, "XC");
        mapping.put(50, "L");
        mapping.put(40, "XL");
        mapping.put(10, "X");
        mapping.put(9, "IX");
        mapping.put(5, "V");
        mapping.put(4, "IV");
        mapping.put(1, "I");
    }

    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        while (num > 0){
            for (int i : nums) {
                if (num >= i) {
                    sb.append(mapping.get(i));
                    num -= i;
                    break;
                }
            }
        }
        return sb.toString();
    }

}
