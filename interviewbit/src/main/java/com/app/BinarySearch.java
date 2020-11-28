package com.app;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String... args) {
        BinarySearch binarySearch = new BinarySearch();

        List<Integer> index = new ArrayList<>();
        index.add(2);
        index.add(1);
        index.add(4);
        index.add(3);
        index.add(2);
        System.out.println(binarySearch.kthsmallest(index, 3));
    }


    public int kthsmallest(final List<Integer> A, int B) {
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int a : A) {
            sorted.add(searchInsert(sorted, a), a);
        }
        return sorted.get(B-1);
    }

    public int searchInsert(ArrayList<Integer> a, int b) {
        int high = a.size() - 1;
        if (high < 0) {
            return 0;
        }
        int low = 0;
        return binarySearch(a, low, high, b);
    }

    public int binarySearch(ArrayList<Integer> list, int low, int high, int seachElement) {

        if (seachElement > list.get(high)) {
            return high + 1;
        }

        if (seachElement < list.get(low)) {
            if (low - 1 == -1) {
                return 0;
            }
            return low - 1;
        }

        if (low == high) {
            return low;
        }

        if (list.get(low) == seachElement) {
            return low;
        } else if (list.get(high) == seachElement) {
            return high;
        }

        int mid = (low + high) / 2;

        if (mid == low || mid == high) {
            return mid + 1;
        }

        if (list.get(mid) == seachElement) {
            return mid;
        } else if (seachElement > list.get(mid)) {
            return binarySearch(list, mid, high, seachElement);
        } else {
            return binarySearch(list, low, mid, seachElement);
        }
    }


}
