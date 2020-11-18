package com.leet.daysofcode.may.week4;


import com.ds.utils.ArrayUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PossibleBipartition {

    public static void main(String[] args) {
        int[] Ns = {4, 3, 5};
        int[][][] dislikes = {{{1, 2}, {1, 3}, {2, 4}}, {{1, 2}, {1, 3}, {2, 3}}, {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}};
        boolean[] outputs = {true, false, false};
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        for (int i = 0; i < Ns.length; i++) {
            System.out.println("N : " + Ns[i] + ", dislikes : " + ArrayUtils.toString(dislikes[i]));
            System.out.println("Output : " + possibleBipartition.possibleBipartition(Ns[i], dislikes[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("#############################################");
        }
    }


    public boolean possibleBipartition(int N, int[][] dislikes) {
        Set<Integer> groupA = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toSet());
        Set<Integer> groupB = new HashSet<>();
        for (int[] dislike : dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            if (groupB.contains(first) && groupB.contains(second)) {
                return false;
            }
            if (groupA.contains(first) && groupA.contains(second)) {
                groupA.remove(second);
                groupB.add(second);
            }
            System.out.println("Group A : "+groupA);
            System.out.println("Group B : "+groupB);
        }
        return true;
    }

}
