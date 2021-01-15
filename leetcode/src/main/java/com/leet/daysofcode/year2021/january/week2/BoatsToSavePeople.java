package com.leet.daysofcode.year2021.january.week2;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[][] people = {{1, 2}, {3, 2, 2, 1}, {3, 5, 3, 4}};
        int[] limit = {3, 3, 5};
        int[] outputs = {1, 3, 4};
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        IntStream.range(0, people.length).forEachOrdered(i -> {
            System.out.println("Input : people -> " + Arrays.toString(people[i]) + " limit : " + limit[i]);
            int output = boatsToSavePeople.numRescueBoats(people[i], limit[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                j--;
                i++;
            } else {
                j--;
            }
            ans++;
        }
        return ans;
    }

    public int usingTreeMap(int[] people, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(people).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        int ans = 0;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> largest = map.lastEntry();
            decrementCount(largest, map);
            Map.Entry<Integer, Integer> pair = map.floorEntry(limit - largest.getKey());
            if (pair != null) {
                decrementCount(pair, map);
            }
            ans++;
        }
        return ans;
    }

    private void decrementCount(Map.Entry<Integer, Integer> entry, TreeMap<Integer, Integer> map) {
        if (entry.getValue() - 1 > 0) {
            map.put(entry.getKey(), entry.getValue() - 1);
        } else {
            map.remove(entry.getKey());
        }
    }

}
