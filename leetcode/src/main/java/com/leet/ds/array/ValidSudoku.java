package com.leet.ds.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));
    }


    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board.length != 9 || board[0].length != 9) {
            return false;
        }
        Set<Character> blank = new HashSet<>();
        Map<Integer, Set<Character>> map = new HashMap<>();
        Map<Integer, Set<Character>> blockMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                Character element = board[i][j];
                if (!element.equals('.')) {
                    int blockNumber = getBlockNumber(i, j);
                    if (rowSet.contains(element) || map.getOrDefault(j, blank).contains(element) || blockMap.getOrDefault(blockNumber, blank).contains(element)) {
                        return false;
                    } else {
                        rowSet.add(element);
                        Set<Character> columnSet = map.getOrDefault(j, new HashSet<>());
                        columnSet.add(element);
                        map.put(j, columnSet);
                        Set<Character> blockSet = blockMap.getOrDefault(blockNumber, new HashSet<>());
                        blockSet.add(element);
                        blockMap.put(blockNumber, blockSet);
                    }
                }
            }
        }
        return true;
    }

    private int getBlockNumber(int i, int j) {
        return ((i / 3) * 3) + ((j / 3) + 1);
    }
}
