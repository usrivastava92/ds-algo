package com.codechef.dsa.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NotAllFlavours {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int maxRun = 0;
            int prevStart = 0;
            int i =0;
            for (i = 0; i < n; i++) {
                map.put(sc.nextInt(), i);
                if (map.size() == k) {
                    int temp = i - prevStart;
                    if (maxRun < temp) {
                        maxRun = temp;
                    }
                    Map.Entry<Integer, Integer> entryForRemoval = findMinValue(map);
                    prevStart = entryForRemoval.getValue() ;
                    map.remove(entryForRemoval.getKey());
                }
            }
            System.out.println(i+" -> "+prevStart);
            int temp = i - prevStart;
            if (maxRun < temp) {
                maxRun = temp;
            }
            System.out.println(maxRun);
        }
        sc.close();
    }

    private static Map.Entry<Integer, Integer> findMinValue(Map<Integer, Integer> map) {
        Map.Entry<Integer, Integer> minEntry = null;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
                minEntry = entry;
            }
        }
        return minEntry;
    }

}
/*
1
13 4
1 1 1 2 2 1 4 3 3 4 4 1 1
 */