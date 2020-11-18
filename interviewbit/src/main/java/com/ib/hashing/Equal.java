package com.ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Equal {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        Equal equal = new Equal();
        System.out.println(equal.equal(arrayList));
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int size = A.size();
        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = A.get(i) + A.get(j);
                if (map.containsKey(sum)) {
                    ArrayList<Integer> ans = new ArrayList<Integer>(map.get(sum));
                    if (!ans.contains(i) && !ans.contains(j)) {
                        ans.add(i);
                        ans.add(j);
                        answers.add(ans);
                    }
                } else {
                    map.put(sum, new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        if (answers.isEmpty()) {
            return new ArrayList<>();
        }
        answers.sort(new ArrayComparator());
        return answers.get(0);
    }
}

class ArrayComparator implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        int firstCompare = o1.get(0).compareTo(o2.get(0));
        if (firstCompare == 0) {
            int secondCompare = o1.get(1).compareTo(o2.get(1));
            if (secondCompare == 0) {
                int thirdCompare = o1.get(2).compareTo(o2.get(2));
                if (thirdCompare == 0) {
                    return o1.get(3).compareTo(o2.get(3));
                } else {
                    return thirdCompare;
                }
            } else {
                return secondCompare;
            }
        } else {
            return firstCompare;
        }
    }

}
