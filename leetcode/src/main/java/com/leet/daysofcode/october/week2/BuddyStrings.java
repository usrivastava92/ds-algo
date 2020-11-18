package com.leet.daysofcode.october.week2;

import java.util.*;
import java.util.stream.IntStream;

public class BuddyStrings {

    public static void main(String[] args) {
        String[] As = {"ab", "ab", "aa", "aaaaaaabc", "", "abcaa", "abac"};
        String[] Bs = {"ba", "ab", "aa", "aaaaaaacb", "aa", "abcbb", "abad"};
        boolean[] outputs = {true, false, true, true, false, false, false};
        BuddyStrings buddyStrings = new BuddyStrings();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("inputs : A : " + As[i] + " B : " + Bs[i]);
            System.out.println("output : " + buddyStrings.buddyStrings(As[i], Bs[i]));
            System.out.println("expected : " + outputs[i]);
            assert buddyStrings.buddyStrings(As[i], Bs[i]) == outputs[i];
        });
    }

    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        A = A.trim();
        B = B.trim();
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (Character character : A.toCharArray()) {
                set.add(character);
            }
            return set.size() < A.length();
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0, len = A.length(); i < len; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if ((list.size() / 2) > 2) {
                    return false;
                }
                list.add(A.charAt(i));
                list.add(B.charAt(i));
            }
        }
        if ((list.size() / 2) < 2) {
            return false;
        }
        return list.get(0).equals(list.get(3)) && list.get(1).equals(list.get(2));
    }

}
