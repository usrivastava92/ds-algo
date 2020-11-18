package com.codechef.dsa.week1;

import com.codechef.utility.Reader;

public class Factorial {


    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            int num = reader.nextInt();
            int ans = 0;
            int powOf5 = 5;
            while (powOf5 <= num) {
                ans += (num / powOf5);
                powOf5 *= 5;
            }
            System.out.println(ans);
        }
        reader.close();
    }


}

/*
6
3
60
100
1024
23456
8735373
 */