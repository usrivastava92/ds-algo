package com.codechef.dsa.week5;

import com.codechef.utility.Reader;

public class AppyAndContest {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();

        int testCases = reader.nextInt();

        while (testCases-- > 0) {
            long n = reader.nextLong();
            long a = reader.nextLong();
            long b = reader.nextLong();
            long k = reader.nextLong();

            long lcm = (a * b) / gcd(a,b);
            long divByLcm = n/lcm;
            long divByA = n/a;
            long divByB = n/b;

            long canBeSolvedByA = divByA - divByLcm;
            long canBeSolvedByB = divByB - divByLcm;

            if(canBeSolvedByA >= k - canBeSolvedByB){
                System.out.println("Win");
            }else{
                System.out.println("Lose");
            }

        }

        reader.close();
    }


    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b,a % b);
    }

}