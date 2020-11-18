package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static void main(String... args) {
        IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();
        Integer[] a = new Integer[]{10000};
        Integer[] b = new Integer[]{10000};
        System.out.println(intersectionOfSortedArrays.intersect(Arrays.asList(a), Arrays.asList(b)));
        //[35, 38, 53, 67, 69, 94, 98]
    }

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int lenA = A.size();
        int lenB = B.size();
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < lenA && j < lenB) {
            if (A.get(i).equals(B.get(j))) {
                result.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

}
