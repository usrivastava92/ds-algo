package com.leet.daysofcode.december.week1;

public class CanPlaceFlowers {

    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if (n <= 0) {
            return true;
        }
        int even = 0;
        int odd = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                if (flowerbed[i] == 0 && (i - 1 <= -1 || flowerbed[i - 1] == 0) && (i + 1 >= len || flowerbed[i + 1] == 0)) {
                    even++;
                }
                if (even >= n) {
                    return true;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && (i + 1 >= len || flowerbed[i + 1] == 0)) {
                    odd++;
                }
                if (odd >= n) {
                    return true;
                }
            }
        }
        return false;
    }

}
