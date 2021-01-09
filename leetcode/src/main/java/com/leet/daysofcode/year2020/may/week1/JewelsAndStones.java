package com.leet.daysofcode.year2020.may.week1;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println(jewelsAndStones.numJewelsInStones(J, S));
    }

    public int numJewelsInStones(String J, String S) {
        int len = S.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (J.contains(String.valueOf(S.charAt(i)))) {
                ans++;
            }
        }
        return ans;
    }

}
