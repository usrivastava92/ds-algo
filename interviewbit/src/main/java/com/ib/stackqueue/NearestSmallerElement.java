package com.ib.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NearestSmallerElement {

    public static void main(String... args) {
        NearestSmallerElement nearestSmallerElement = new NearestSmallerElement();
        nearestSmallerElement.prevSmaller(Arrays.asList(8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34));
    }

    public ArrayList<Integer> prevSmaller(List<Integer> A) {
        int size = A.size();
        ArrayList<Integer> array = new ArrayList<>();
        int minToLeft = A.get(0);
        array.add(-1);
        for (int i = 1; i < size; i++) {
            Integer element = A.get(i);
            if (element <= minToLeft) {
                array.add(-1);
                minToLeft = element;
            } else {
                for (int j = i - 1; j > -1; j--) {
                    if (A.get(j) < element) {
                        array.add(A.get(j));
                        break;
                    }
                }
            }
        }
        return array;
    }


}
