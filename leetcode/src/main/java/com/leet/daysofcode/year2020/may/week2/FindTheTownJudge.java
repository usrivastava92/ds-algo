package com.leet.daysofcode.year2020.may.week2;

public class FindTheTownJudge {

    public static void main(String[] args) {
        FindTheTownJudge findTheTownJudge = new FindTheTownJudge();
        int[][][] trusts = {{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}};
        int[] Ns = {4};
        int testCase = 0;
        System.out.println(findTheTownJudge.findJudge(Ns[testCase], trusts[testCase]));
    }


    public int findJudge(int N, int[][] trust) {
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        for (int[] tr : trust) {
            arr1[tr[0] - 1]++;
            arr2[tr[1] - 1]++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0 && arr2[i] == (N - 1)) {
                return i + 1;
            }
        }
        return -1;
    }
}
