package com.codechef.dsa.week1;

import com.codechef.utility.Reader;

public class CoinFlip {


    public static void main(String[] args) throws Exception {

        Reader reader = new Reader();
        int testCase = reader.nextInt();
        while (testCase-- > 0) {
            int games = reader.nextInt();
            while (games-- > 0) {
                int initial = reader.nextInt();
                int rounds = reader.nextInt();
                int query = reader.nextInt();
                int ans = 0;
                if (query == initial) {
                    ans = rounds / 2;
                } else {
                    ans = (int) Math.ceil(rounds / 2.0);
                }
                System.out.println(ans);
            }
        }
        reader.close();


    }

}

/*
1
2
1 5 1
1 5 2
 */