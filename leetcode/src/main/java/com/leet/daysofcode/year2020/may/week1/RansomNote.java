package com.leet.daysofcode.year2020.may.week1;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b"));// false
        System.out.println(ransomNote.canConstruct("aa", "ab")); // false
        System.out.println(ransomNote.canConstruct("aa", "aab")); // true
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (Character ch : magazine.toCharArray()) {
            magazineMap.put(ch, magazineMap.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : ransomNote.toCharArray()) {
            if (magazineMap.containsKey(ch)) {
                magazineMap.put(ch, magazineMap.get(ch) - 1);
                if (magazineMap.get(ch) <= 0) {
                    magazineMap.remove(ch);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}