package com.leet.daysofcode.year2020.april.week4;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueNumber {

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }

}

class FirstUnique {

    private Queue<Integer> queue;
    private Map<Integer, Integer> countMap;
    private int firstUnique = -1;

    public FirstUnique(int[] nums) {
        queue = new ArrayDeque<>();
        countMap = new HashMap<>();
        for (int num : nums) {
            queue.add(num);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        findFirstUnique();
    }

    private void findFirstUnique() {
        while (!queue.isEmpty() && countMap.get(queue.peek()) != 1) {
            queue.poll();
        }
        if (!queue.isEmpty()) {
            firstUnique = queue.poll();
        } else {
            firstUnique = -1;
        }
    }

    public int showFirstUnique() {
        return firstUnique;
    }

    public void add(int value) {
        queue.add(value);
        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        if (firstUnique == -1 || value == firstUnique) {
            findFirstUnique();
        }
    }
}

