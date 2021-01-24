package com.prep.practice;

import java.util.*;
import java.util.stream.IntStream;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[][] inputs = {{"i", "love", "leetcode", "i", "love", "coding"}, {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}};
        int[] ks = {2, 4};
        String[][] outputs = {{"i", "love"}, {"the", "is", "sunny", "day"}};
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]) + "  | k : " + ks[i]);
            System.out.println("Output : " + topKFrequentWords.topKFrequent(inputs[i], ks[i]));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((i, j) -> {
            int comp = Integer.compare(j.getValue(), i.getValue());
            return comp == 0 ? i.getKey().compareTo(j.getKey()) : comp;
        });
        System.out.println(map);
        maxHeap.addAll(map.entrySet());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(Objects.requireNonNull(maxHeap.poll()).getKey());
        }
        return ans;
    }
}
