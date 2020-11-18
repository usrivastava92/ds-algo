package com.codechef.dsa.week4;

import com.codechef.utility.Reader;

import java.util.ArrayList;
import java.util.List;

public class EuronProblem {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //int element = (int) (Math.random() * 100);
            int element = reader.nextInt();
            int violations = addInList(list, element);
            total += violations;
        }
        System.out.println(total);
        reader.close();
    }

    private static int addInList(List<Integer> list, Integer i) {
        System.out.println(list);
        int high = list.size() - 1;
        if (list.isEmpty() || list.get(high).compareTo(i) <= 0) {
            list.add(i);
            return 0;
        }
        int low = 0;
        while (high > low) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).compareTo(i) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (list.get(low).compareTo(i) <= 0) {
            low++;
        }
        System.out.println("added at index -> " + low);
        list.add(low, i);
        return list.size() - low - 1;
    }

}
/*
5
4 5 6 7 1

5
5 4 3 2 1

6
95 16 52 50 52 89
*/