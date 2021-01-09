package com.leet.daysofcode.year2020.october.week3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepeatedDNASequences {

    public static void main(String[] args) {
        String[] inputs = {"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", "AAAAAAAAAAAAA"};
        List<List<String>> outputs = Arrays.asList(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"), Arrays.asList("AAAAAAAAAA"));
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + repeatedDNASequences.findRepeatedDnaSequences(inputs[i]));
            System.out.println("Expected : " + outputs.get(i));
        });
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return Collections.emptyList();
        }
        Set<String> repeating = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String substring = s.substring(i - 10, i);
            if (set.contains(substring)) {
                repeating.add(substring);
            } else {
                set.add(substring);
            }
        }
        return repeating.stream().collect(Collectors.toList());
    }

}
