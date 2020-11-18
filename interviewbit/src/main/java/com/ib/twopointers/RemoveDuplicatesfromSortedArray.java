package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String... args) {
        RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();
        System.out.println(removeDuplicatesfromSortedArray.removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3))));
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() <= 1) return a.size();
        int i = 1;
        int j = 1;
        while (i < a.size()) {
            if (!a.get(i).equals(a.get(i - 1))) {
                a.set(j, a.get(i));
                j++;
            }
            i++;
        }
        System.out.println(a);
        ArrayList<Integer> itemsToKeep = new ArrayList<>();
        i = 0;
        while (i < j) {
            itemsToKeep.add(a.get(i++));
        }
        a.clear();
        for (int num : itemsToKeep) {
            a.add(num);
        }
        return a.size();
    }

}
