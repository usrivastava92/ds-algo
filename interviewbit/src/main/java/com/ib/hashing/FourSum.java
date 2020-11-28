package com.ib.hashing;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2)), 0));
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        int size = A.size();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = A.get(i) + A.get(j);
                ArrayList<ArrayList<Integer>> value = map.getOrDefault(sum, new ArrayList<>());
                value.add(new ArrayList<>(Arrays.asList(i, j)));
                map.put(sum, value);
            }
        }
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();

        HashMap<ArrayList<Integer>, Integer> map1 = new HashMap<>();

        for (Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry : map.entrySet()) {
            int sum1 = entry.getKey();
            int requiredSum = B - sum1;
            if (map.containsKey(requiredSum)) {
                ArrayList<ArrayList<Integer>> secondItems = map.get(requiredSum);
                for (ArrayList<Integer> item1 : entry.getValue()) {
                    for (ArrayList<Integer> item2 : secondItems) {
                        int a = item1.get(0);
                        int b = item1.get(1);
                        int c = item2.get(0);
                        int d = item2.get(1);
                        if (a != c && a != d && b != c && b != d) {
                            ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(A.get(a), A.get(b), A.get(c), A.get(d)));
                            Collections.sort(temp);
                            if (!map1.containsKey(temp)) {
                                map1.put(temp, 1);
                                returnList.add(temp);
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(returnList, new ListComparator());
        return returnList;
    }
}

class ListComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        int comparison1 = o1.get(0).compareTo(o2.get(0));
        if (comparison1 == 0) {
            int comparison2 = o1.get(1).compareTo(o2.get(1));
            if (comparison2 == 0) {
                int comparison3 = o1.get(2).compareTo(o2.get(2));
                if (comparison3 == 0) {
                    return o1.get(3).compareTo(o2.get(3));
                }
                return comparison3;
            }
            return comparison2;
        }
        return comparison1;
    }
}