package com.app;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rowSize = Integer.parseInt(sc.nextLine());
        List<String> arr = new ArrayList<>();
        List<String> trans = new ArrayList<>();
        int colSize = 0;

        for (int i = 0; i < rowSize; i++) {
            String line = sc.nextLine().replaceAll("#", "");
            arr.add(line);
            int col = line.length();
            colSize = col;
            for (int z = 0; z < col; z++) {
                try {
                    String old = trans.get(z);
                    trans.set(z, old + line.substring(z, z + 1));
                } catch (Exception e) {
                    trans.add(line.substring(z, z + 1));
                }
            }
        }

        String searchString = sc.nextLine();
        Pattern p = Pattern.compile(searchString);

        sc.close();

        List<String> leadingDiagnols = new ArrayList<>();
        List<String> trailingDiagnols = new ArrayList<>();
        int colRowDiff = Math.abs(colSize - rowSize);
        int min = colSize < rowSize ? colSize : rowSize;

        for (int diagNo = 0; diagNo <= colRowDiff; diagNo++) {
            String leading = "";
            String trailing = "";
            for (int i = 0; i < min; i++) {
                leading += arr.get(i).substring(i + diagNo, i + 1 + diagNo);
                trailing += arr.get(rowSize - i - 1).substring(i + diagNo, i + 1 + diagNo);
            }
            leadingDiagnols.add(leading);
            trailingDiagnols.add(trailing);
        }

        int matchCount = 0;
        for (String row : arr) {
            Matcher m = p.matcher(row);
            while (m.find()) {
                matchCount++;
            }
        }


        for (String col : trans) {
            Matcher m = p.matcher(col);
            while (m.find()) {
                matchCount++;
            }
        }


        for (String leading : leadingDiagnols) {
            Matcher m = p.matcher(leading);
            while (m.find()) {
                matchCount++;
            }
        }
        for (String trailing : trailingDiagnols) {
            Matcher m = p.matcher(trailing);
            while (m.find()) {
                matchCount++;
            }
        }
        System.out.print(matchCount);
    }

    public static void printArr(String[][] arr) {
        for (String[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[] getIndexByBlockNumber(int i, int j, int blockNumber) {
        int rowNumber = blockNumber / j;
        int columnNumber = blockNumber % j;
        if (columnNumber == 0) {
            columnNumber = j - 1;
            rowNumber--;
        } else {
            columnNumber--;
        }
        return new int[]{rowNumber, columnNumber};
    }

    public int searchMatrix(int[][] A, int B) {
        int i = A.length;
        int j = 0;
        if (i > 0) {
            j = A[0].length;
        }
        int high = i * j;
        int low = 1;
        int[] lowIndex = getIndexByBlockNumber(i, j, low);
        int[] highIndex = getIndexByBlockNumber(i, j, high);
        if (A[lowIndex[0]][lowIndex[1]] == B || A[highIndex[0]][highIndex[1]] == B) {
            return 1;
        }
        return binarySearch(A, low, high, i, j, B);
    }


    public int binarySearch(int[][] A, int low, int high, int i, int j, int searchElement) {
        if (low == high || high < low) {
            return 0;
        }
        int mid = (high + low) / 2;

        if (mid == low || mid == high) {
            return 0;
        }

        int[] midIndex = getIndexByBlockNumber(i, j, mid);
        int midElement = A[midIndex[0]][midIndex[1]];
        if (midElement == searchElement) {
            return 1;
        } else if (searchElement > midElement) {
            return binarySearch(A, mid, high, i, j, searchElement);
        } else {
            return binarySearch(A, low, mid, i, j, searchElement);
        }
    }


}