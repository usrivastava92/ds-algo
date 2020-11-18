package com.ib.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffkIi {


    public static void main(String[] args) {
        DiffkIi diffkIi = new DiffkIi();
        System.out.println(diffkIi.diffPossible(Arrays.asList(1, 5, 4, 1, 2),0));
    }

    private int diffPossible(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : A) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }
        for (Integer first : A) {
            Integer second = B + first;
            if (map.containsKey(second)) {
                if (first.equals(second)) {
                    if (map.get(second).compareTo(1) > 0) {
                        return 1;
                    }
                    return 0;
                }
                return 1;
            }
        }

        return 0;
    }
}
