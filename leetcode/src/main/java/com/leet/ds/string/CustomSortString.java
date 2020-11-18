package com.leet.ds.string;

public class CustomSortString {

    public static void main(String[] args) {
        String[] S = {"cba"};
        String[] T = {"abcd"};
        int testCase = 0;
        CustomSortString customSortString = new CustomSortString();
        System.out.println(customSortString.customSortString(S[testCase], T[testCase]));
    }

    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];

        for (char c : T.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int index = ch - 'a';
            while (arr[index]-- > 0) {
                sb.append(ch);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                sb.append((char) (i + 97));
            }
        }

        return sb.toString();
    }

}
