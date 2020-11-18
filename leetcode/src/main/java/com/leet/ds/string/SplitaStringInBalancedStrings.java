package com.leet.ds.string;

public class SplitaStringInBalancedStrings {

    public static void main(String[] args) {
        SplitaStringInBalancedStrings splitaStringInBalancedStrings = new SplitaStringInBalancedStrings();
        String s = "RLRRRLLRLL";
        System.out.println(splitaStringInBalancedStrings.balancedStringSplit(s));
    }

    public int balancedStringSplit(String s) {
        int sum = 0;
        int ans = 0;
        for (int i=0,len=s.length();i<len;i++) {
            Character ch = s.charAt(i);
            if (ch == 'R') {
                sum++;
            } else if (ch == 'L') {
                sum--;
            }
            if (sum == 0) {
                ans++;
            }
        }
        return ans;
    }
}
