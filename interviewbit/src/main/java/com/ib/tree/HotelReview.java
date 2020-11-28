package com.ib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class HotelReview {

    public static void main(String... args) {
        HotelReview hotelReview = new HotelReview();
        String A = "cool_ice_wifi_l...";
        ArrayList<String> B = new ArrayList<>(Arrays.asList("c_w_i", "water_is_cool", "cold_ice_drink", "i_w_c_l", "cool_wifi_speed"));
        System.out.println(hotelReview.solve(A, B));
    }


    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        String[] keywords = A.split("_");
        TrieNode root = new TrieNode(' ');
        for (String keyword : keywords) {
            TrieUtils.addString(keyword, root);
        }
        TrieUtils.printTrie(root);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minMatches = Integer.MAX_VALUE;
        int maxMatches = Integer.MIN_VALUE;
        for (int i = 0, size = B.size(); i < size; i++) {
            String review = B.get(i);
            int matches = 0;
            String[] words = review.split("_");
            for (String word : words) {
                if (TrieUtils.searchString(word, root)) {
                    matches++;
                }
            }
            if (matches > maxMatches) {
                maxMatches = matches;
            }
            if (matches < minMatches) {
                minMatches = matches;
            }
            ArrayList<Integer> list = map.getOrDefault(matches, new ArrayList<>());
            list.add(i);
            map.put(matches, list);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = maxMatches; i >= minMatches; i--) {
            if (map.containsKey(i)) {
                for (Integer index : map.get(i)) {
                    result.add(index);
                }
            }
        }
        return result;
    }
}

