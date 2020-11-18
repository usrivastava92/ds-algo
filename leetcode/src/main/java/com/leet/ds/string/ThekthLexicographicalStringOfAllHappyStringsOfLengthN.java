package com.leet.ds.string;

public class ThekthLexicographicalStringOfAllHappyStringsOfLengthN {


    public static void main(String[] args) {
        ThekthLexicographicalStringOfAllHappyStringsOfLengthN the = new ThekthLexicographicalStringOfAllHappyStringsOfLengthN();
        int n = 10;
        int k = 100;
        System.out.println(the.getHappyString(n, k));
    }

    int[] powOf4 = new int[]{1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576};

    public String getHappyString(int n, int k) {
        if (k > powOf4[n]) {
            return "";
        }
        String ans = "";
        if (k == powOf4[n]) {
            while (n-- > 0) {
                ans += "d";
            }
            return ans;
        }
        int temp = n;
        while (k < powOf4[temp]) {
            temp--;
        }
        System.out.println((temp + 1) + " : " + powOf4[temp]);
        return "";
    }

}
//ensemencement@homeinteriorcorner.com