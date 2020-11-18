package com.ib.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DifferentBitsSumPairwise {

    public static void main(String... args) {
        DifferentBitsSumPairwise differentBitsSumPairwise = new DifferentBitsSumPairwise();


        System.out.println(differentBitsSumPairwise.cntBits(new ArrayList<>(Arrays.asList(1, 3, 5))));
    }

    public int cntBits(ArrayList<Integer> A) {
        int size = A.size();
        Long sum = 0L;
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Integer a = A.get(i);
                Integer b = A.get(j);
                String key1 = a + "," + b;
                String key2 = b + "," + a;
                if (a != b) {
                    Long diffBit = null;
                    if (map.get(key1) != null) {
                        diffBit = map.get(key1);
                    } else if (map.get(key2) != null) {
                        diffBit = map.get(key2);
                    } else {
                        diffBit = countDiffBit(a, b);
                        map.put(key1, diffBit);
                    }
                    sum += diffBit;
                }
            }
        }
        sum = sum % 1000000007;
        return sum.intValue();
    }


    private long countDiffBit(int a, int b) {
        return Integer.toBinaryString(a ^ b).replaceAll("0", "").length();
    }
}
