package com.leet.ds.hash;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String[] inputs = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        int[] outputs = {3, 4, 9, 58, 1994};
        RomanToInteger romanToInteger = new RomanToInteger();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : \"" + inputs[i] + "\"");
            System.out.println("Output : " + romanToInteger.romanToInt(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("##########################################");
        }
    }

    private Map<Character, Integer> mapping = new HashMap<>();

    {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int len = s.length();
        int num = 0;
        while (i < len) {
            char ch = s.charAt(i);
            int next = i + 1;
            if (ch == 'I' && next < len && (s.charAt(next) == 'V' || s.charAt(next) == 'X')) {
                num += (mapping.get(s.charAt(next))-mapping.get(ch));
                i += 2;
            } else if (ch == 'X' && next < len && (s.charAt(next) == 'L' || s.charAt(next) == 'C')) {
                num += (mapping.get(s.charAt(next))-mapping.get(ch));
                i += 2;
            } else if (ch == 'C' && next < len && (s.charAt(next) == 'D' || s.charAt(next) == 'M')) {
                num += (mapping.get(s.charAt(next))-mapping.get(ch));
                i += 2;
            } else {
                num += mapping.get(ch);
                i++;
            }
        }
        return num;
    }

}
