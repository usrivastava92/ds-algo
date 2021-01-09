package com.leet.daysofcode.year2020.june.week2;

public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int schlen = s.length();
        int tchlen = t.length();
        while (i < schlen && j < tchlen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == schlen) {
            return true;
        }
        return false;
    }
}
