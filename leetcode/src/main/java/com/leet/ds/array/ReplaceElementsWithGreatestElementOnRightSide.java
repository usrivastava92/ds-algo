package com.leet.ds.array;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSide rep = new ReplaceElementsWithGreatestElementOnRightSide();
        int[] arr = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(rep.replaceElements(arr)));
    }

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i > -1; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (max < temp) {
                max = temp;
            }
        }
        return arr;
    }


}
