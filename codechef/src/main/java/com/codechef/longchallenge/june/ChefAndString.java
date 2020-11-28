package com.codechef.longchallenge.june;

import com.codechef.utility.Reader;

import java.util.Scanner;

public class ChefAndString {

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        int testCase = reader.nextInt();
        while (testCase-- > 0) {
            String input = reader.nextLine();
            int i = 0;
            int len = input.length();
            int pairs = 0;
            while (i < len) {
                char curr = input.charAt(i);
                if (i + 1 < len) {
                    char next = input.charAt(i + 1);
                    if (curr != next) {
                        pairs++;
                        i++;
                    }
                }
                i++;
            }
            System.out.println(pairs);
        }
        reader.close();
    }

}
