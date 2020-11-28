package com.ib.hashing;

import java.util.HashMap;
import java.util.Map;

public class ColorfulNumber {
    public static void main(String[] args) {
        ColorfulNumber colorfulNumber = new ColorfulNumber();
        System.out.println(colorfulNumber.colorful(1234));
    }

    public int colorful(int A) {
        String num = String.valueOf(A);
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0, size = num.length(); i < size; i++) {
            for (int j = 0, len = size - i; j < len; j++) {
                long multiply = 1;
                String substr = num.substring(j, j + i + 1);
                for (int z = 0, l = substr.length(); z < l; z++) {
                    multiply *= Character.getNumericValue(substr.charAt(z));
                }
                if (map.containsKey(multiply)) {
                    return 0;
                } else {
                    map.put(multiply, 1);
                }
            }
        }
        return 1;
    }
}
