package com.codechef.longchallenge.june;

import com.codechef.utility.Reader;

public class TheTomAndJerryGame {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            long num = reader.nextLong();
            while (num % 2 == 0) {
                num = num / 2;
            }
            System.out.println(num / 2);
        }
        reader.close();
    }

}

