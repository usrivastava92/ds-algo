package com.leet.daysofcode.year2020.may.week4;

import java.util.*;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String[] inputs = {"tree", "cccaaa", "Aabb", "loveleetcode"};
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        for (String input : inputs) {
            long start = System.currentTimeMillis();
            System.out.println(input + " -> " + sortCharactersByFrequency.frequencySortNlogN(input));
            System.out.println("Time of execution -> " + (System.currentTimeMillis() - start) + " ms");
            start = System.currentTimeMillis();
            System.out.println(input + " -> " + sortCharactersByFrequency.frequencySortN(input));
            System.out.println("Time of execution -> " + (System.currentTimeMillis() - start) + " ms");
        }
    }

    private String frequencySortN(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int bucketId = entry.getValue();
            if (buckets[bucketId] == null) {
                buckets[bucketId] = new ArrayList<>();
            }
            buckets[bucketId].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > -1; i--) {
            if (buckets[i] != null) {
                for (Character ch : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }


    public String frequencySortNlogN(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Character[] list = new Character[s.length()];
        int i = 0;
        for (Character ch : s.toCharArray()) {
            list[i++] = ch;
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        FreqComparator freqComparator = new FreqComparator(freqMap);
        Arrays.sort(list, freqComparator);
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }

}

class FreqComparator implements Comparator<Character> {

    private Map<Character, Integer> freqMap;

    FreqComparator(Map<Character, Integer> freqMap) {
        this.freqMap = freqMap;
    }

    @Override
    public int compare(Character o1, Character o2) {
        int comp = Integer.compare(freqMap.get(o2), freqMap.get(o1));
        if (comp == 0) {
            return Character.compare(o1, o2);
        }
        return comp;
    }
}