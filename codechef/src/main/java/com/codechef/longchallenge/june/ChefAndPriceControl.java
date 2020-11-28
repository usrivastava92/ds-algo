package com.codechef.longchallenge.june;

import com.codechef.utility.Reader;

public class ChefAndPriceControl {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();

        int testCases = reader.nextInt();

        while (testCases-- > 0) {
            int n = reader.nextInt();
            int t = reader.nextInt();
            int sum = 0;
            while (n-- > 0) {
                int num = reader.nextInt();
                if (num > t) {
                    sum += (num - t);
                }
            }
            System.out.println(sum);
        }

        reader.close();
    }


}
