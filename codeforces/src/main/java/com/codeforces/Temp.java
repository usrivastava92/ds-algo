package com.codeforces;

import com.ds.utils.NumberUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Temp {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 26; i++) {
            int random = NumberUtils.getRandomInt(65, 90);
            while (set.contains(random)) {
                random = NumberUtils.getRandomInt(65, 90);
            }
            set.add(random);
            System.out.println((char) random);
            scanner.nextLine();
        }
        scanner.close();
    }
}
