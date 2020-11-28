package com.codechef.dsa.week5;

import com.codechef.utility.Reader;

public class ZackAndTheHandkerchieves {

    public static void main(String[] args) throws  Exception{
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        while (testCases-- > 0){
            int l = reader.nextInt();
            int b = reader.nextInt();
            System.out.println(gcd(l,b));
        }
        reader.close();
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }
}
