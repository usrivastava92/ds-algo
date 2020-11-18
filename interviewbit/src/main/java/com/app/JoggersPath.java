package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JoggersPath {
    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        int len = Integer.parseInt(sc.nextLine());
        char[] jogString = sc.nextLine().toCharArray();
        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        sc.close();
        int totalWays = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == jogString[0]) {
                    if (len > 1) {
                        totalWays += traverseString(jogString, i, j, 1, matrix, len);
                    } else {
                        totalWays++;
                    }
                }
            }
        }
        System.out.println(totalWays);
    }



    static int traverseString(char[] jogString, int i, int j, int fromIndex, char[][] matrix, int len) {
        if (fromIndex == len) {
            return 1;
        }
        int totalWays = 0;
        char ch = jogString[fromIndex];
        if (j + 1 < 8) {
            int x = i;
            int y = j + 1;
            if (matrix[x][y] == ch) {
                totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
            }
        }
        if (j - 1 > -1) {
            int x = i;
            int y = j - 1;
            if (matrix[x][y] == ch) {
                totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
            }
        }
        if (i + 1 < 8) {
            int x = i + 1;
            int y = j;
            if (matrix[x][y] == ch) {
                totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
            }
        }
        if (i - 1 > -1) {
            int x = i - 1;
            int y = j;
            if (matrix[x][y] == ch) {
                totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
            }
        }
        if (i + 1 < 8) {
            if (j + 1 < 8) {
                int x = i + 1;
                int y = j + 1;
                if (matrix[x][y] == ch) {
                    totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
                }
            }
            if (j - 1 > -1) {
                int x = i + 1;
                int y = j - 1;
                if (matrix[x][y] == ch) {
                    totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
                }
            }
        }
        if (i - 1 > -1) {
            if (j + 1 < 8) {
                int x = i - 1;
                int y = j + 1;
                if (matrix[x][y] == ch) {
                    totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
                }
            }
            if (j - 1 > -1) {
                int x = i - 1;
                int y = j - 1;
                if (matrix[x][y] == ch) {
                    totalWays += traverseString(jogString, x, y, fromIndex + 1, matrix, len);
                }
            }
        }
        return totalWays;
    }

    static List<int[]> getNeighbouringIndexes(int i, int j) {
        List<int[]> indexes = new ArrayList<>();
        if (j + 1 < 8) {
            indexes.add(new int[]{i, j + 1});
        }
        if (j - 1 > -1) {
            indexes.add(new int[]{i, j - 1});
        }
        if (i + 1 < 8) {
            indexes.add(new int[]{i + 1, j});
        }
        if (i - 1 > -1) {
            indexes.add(new int[]{i - 1, j});
        }
        if (i + 1 < 8) {
            if (j + 1 < 8) {
                indexes.add(new int[]{i + 1, j + 1});
            }
            if (j - 1 > -1) {
                indexes.add(new int[]{i + 1, j - 1});
            }
        }
        if (i - 1 > -1) {
            if (j + 1 < 8) {
                indexes.add(new int[]{i - 1, j + 1});
            }
            if (j - 1 > -1) {
                indexes.add(new int[]{i - 1, j - 1});
            }
        }
        return indexes;
    }
}
