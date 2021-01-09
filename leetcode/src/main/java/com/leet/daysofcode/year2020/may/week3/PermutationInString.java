package com.leet.daysofcode.year2020.may.week3;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        String[] s1s = {"ab", "abc", "ooo"};
        String[] s2s = {"eidbaooo", "eidbaooo", "eidbaooo"};

        PermutationInString permutationInString = new PermutationInString();
        for (int i = 0; i < s1s.length; i++) {
            System.out.println("s1 : " + s1s[i] + " s2 : " + s2s[i] + " -> " + permutationInString.checkInclusion(s1s[i], s2s[i]));
        }
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.isEmpty()) {
            return true;
        }
        if (s2.isEmpty()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        for (Character ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }
        int window = s1.length();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < window && i < s2.length(); i++) {
            Character ch = s2.charAt(i);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
        }
        if (s1Map.equals(s2Map)) {
            return true;
        }
        for (int i = 0, len = s2.length() - window; i < len; i++) {
            Character charToBeRemoved = s2.charAt(i);
            s2Map.put(charToBeRemoved, s2Map.getOrDefault(charToBeRemoved, 0) - 1);
            if (s2Map.get(charToBeRemoved).compareTo(0) <= 0) {
                s2Map.remove(charToBeRemoved);
            }
            Character charToBeAdded = s2.charAt(i + window);
            s2Map.put(charToBeAdded, s2Map.getOrDefault(charToBeAdded, 0) + 1);
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }

}
