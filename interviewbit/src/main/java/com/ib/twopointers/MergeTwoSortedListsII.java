package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedListsII {

    public static void main(String... args) {
        MergeTwoSortedListsII mergeTwoSortedListsII = new MergeTwoSortedListsII();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList( 3 ));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(-4, -3));
        mergeTwoSortedListsII.merge(A, B);
        System.out.println(A);
        //[35, 38, 53, 67, 69, 94, 98]
    }

    public void merge(ArrayList<Integer> A, ArrayList<Integer> B) {
        int lenB = B.size();
        int j = 0;
        for (int i = 0; i < A.size(); i++) {
            System.out.println(i+" "+j);
            if (j >= lenB) {
                break;
            }
            if (A.get(i) >= B.get(j)) {
                A.add(i--, B.get(j++));
            }
        }
        while (j < lenB) {
            System.out.println(j);
            A.add(B.get(j));
            j++;
        }
    }

}
