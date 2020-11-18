package com.leet.daysofcode.may.week2;


import com.ds.utils.ArrayUtils;

public class FloodFill {

    public static void main(String[] args) {
        int[][][] images = {{{0, 0, 0}, {0, 1, 1}}, {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}};
        int[] srs = {1, 1};
        int[] scs = {1, 1};
        int[] newColors = {1, 2};
        int testCase = 0;

        FloodFill floodFill = new FloodFill();
        ArrayUtils.printArr(images[testCase]);
        System.out.println("###########################");
        ArrayUtils.printArr(floodFill.floodFill(images[testCase], srs[testCase], scs[testCase], newColors[testCase]));

    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc]==newColor) {
            return image;
        }
        int startingPixelColor = image[sr][sc];
        image[sr][sc] = newColor;
        if ((sr - 1) > -1 && (image[sr - 1][sc] == startingPixelColor)) {
            floodFill(image, sr - 1, sc, newColor);
        }
        if ((sr + 1) < image.length && (image[sr + 1][sc] == startingPixelColor)) {
            floodFill(image, sr + 1, sc, newColor);
        }
        if ((sc - 1) > -1 && (image[sr][sc - 1] == startingPixelColor)) {
            floodFill(image, sr, sc - 1, newColor);
        }
        if ((sc + 1) < image[0].length && (image[sr][sc + 1] == startingPixelColor)) {
            floodFill(image, sr, sc + 1, newColor);
        }
        return image;
    }
}
