package com.leet.ds.hash;

import java.util.HashMap;
import java.util.Map;

public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        String[] word1 = {"sea"};
        String[] word2 = {"eat"};
        int testCase = 0;
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
        System.out.println(deleteOperationForTwoStrings.minDistance(word1[testCase], word2[testCase]));
    }

    public int minDistance(String word1, String word2) {
        Map<Character, Integer> w1Map = new HashMap<>();
        Map<Character, Integer> w2Map = new HashMap<>();

        for (Character ch : word1.toCharArray()) {
            w1Map.put(ch, w1Map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : word2.toCharArray()) {
            w2Map.put(ch, w2Map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(w1Map);
        System.out.println(w2Map);
        int sum = 0;

        for (Map.Entry<Character, Integer> entry : w1Map.entrySet()) {
            if (w2Map.containsKey(entry.getKey())) {
                if (entry.getValue() > w2Map.get(entry.getKey())) {
                    System.out.println("w1 : " + entry.getKey() + " : " + entry.getValue() + " : " + w2Map.get(entry.getKey()));
                    sum += (entry.getValue() - w2Map.get(entry.getKey()));
                }
            } else {
                System.out.println("w1 : " + entry.getKey());
                sum += entry.getValue();
            }
        }

        for (Map.Entry<Character, Integer> entry : w2Map.entrySet()) {
            if (w1Map.containsKey(entry.getKey())) {
                if (entry.getValue() > w1Map.get(entry.getKey())) {
                    System.out.println("w2 : " + entry.getKey() + " : " + entry.getValue() + " : " + w1Map.get(entry.getKey()));
                    sum += (entry.getValue() - w1Map.get(entry.getKey()));
                }
            } else {
                System.out.println("w2 : " + entry.getKey());
                sum += entry.getValue();
            }
        }

        return sum;

    }

}
