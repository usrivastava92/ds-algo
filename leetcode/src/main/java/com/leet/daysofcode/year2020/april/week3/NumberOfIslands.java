package com.leet.daysofcode.year2020.april.week3;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        String input = "111\n" +
                "010\n" +
                "111";
        String[] tokens = input.split("\n");
        char[][] grid = new char[tokens.length][];
        for (int i = 0; i < tokens.length; i++) {
            grid[i] = tokens[i].toCharArray();
        }
        System.out.println(numberOfIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int xlen = grid.length;
        int noOfIsland = 0;
        if (xlen > 0) {
            int ylen = grid[0].length;
            for (int i = 0; i < xlen; i++) {
                for (int j = 0; j < ylen; j++) {
                    if (grid[i][j] == '1') {
                        noOfIsland++;
                        traverse(grid,i,j);
                    }
                }
            }
        }
        return noOfIsland;
    }

    private void traverse(char[][] grid, int i, int j) {
        if (j >= grid[0].length || i >= grid.length || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'X';
        traverse(grid,i+1,j);
        traverse(grid,i-1,j);
        traverse(grid,i,j+1);
        traverse(grid,i,j-1);
    }

}
