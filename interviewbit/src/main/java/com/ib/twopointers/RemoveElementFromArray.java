package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {

    public static void main(String... args) {
        RemoveElementFromArray removeElementFromArray = new RemoveElementFromArray();
        System.out.println(removeElementFromArray.removeElement(new ArrayList<>(Arrays.asList(4, 1, 1, 2, 1, 3)), 1));
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int i = 0;
        int j = 0;

        while (i<a.size()) {
            System.out.println(a+" "+i +" "+j);
            if (a.get(i) != b) {
                if (i != j) {
                    a.set(j, a.get(i));
                    a.set(i, b);
                }
                j++;
            }
            i++;
        }
        System.out.println(a);

        return j;
    }

}
