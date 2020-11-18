package com.ib.hashing;

import java.util.*;

public class ValidSudoku {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        PriorityQueue<Integer> p = new PriorityQueue<>();
        Arrays.stream(a).boxed().forEach(p::add);
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(Arrays.asList(new String[]{"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"})));
    }

    public int isValidSudoku(final List<String> A) {
        Map<Character, Integer> map = new HashMap<>();
        int row = 9;
        int col = 9;
        for (String s : A) {
            for (char ch : s.toCharArray()) {
                if (ch != '.') {
                    if (map.containsKey(ch)) {
                        return 0;
                    } else {
                        map.put(ch, 1);
                    }
                }
            }
            map.clear();
        }
        for (int i = 0; i < col; i++) {
            for (String s : A) {
                Character ch = s.charAt(i);
                if (ch != '.') {
                    if (map.containsKey(ch)) {
                        return 0;
                    } else {
                        map.put(ch, 1);
                    }
                }
            }
            map.clear();
        }
        for (int i = 0; i < row; i = i + 3) {
            for (int j = 0; j < col; j = j + 3) {
                for (int x = i, sizeX = i + 3; x < sizeX; x++) {
                    for (int y = j, sizeY = j + 3; y < sizeY; y++) {
                        Character ch = A.get(x).charAt(y);
                        if (ch != '.') {
                            if (map.containsKey(ch)) {
                                return 0;
                            } else {
                                map.put(ch, 1);
                            }
                        }
                    }
                }
                map.clear();
            }
        }
        return 1;
    }


}
