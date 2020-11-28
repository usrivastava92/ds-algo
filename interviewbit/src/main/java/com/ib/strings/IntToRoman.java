package com.ib.strings;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    Map<Integer, String> map = new HashMap<>();

    {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(23));
    }

    public  String intToRoman(int A) {
        int[] bars = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int len = bars.length;
        String roman = "";
        while (A != 0) {
            for (int i : bars) {
                int bar = bars[i];
                if (A >= bar) {
                    roman += map.get(bar);
                    A = A - bar;
                    System.out.println(A + " " + bar + " " + map.get(bar));
                    break;
                }
            }
        }
        return roman;
    }
}
