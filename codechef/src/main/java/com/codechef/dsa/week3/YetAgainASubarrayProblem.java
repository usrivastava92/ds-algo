package com.codechef.dsa.week3;

import com.codechef.utility.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class YetAgainASubarrayProblem {


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            int n = reader.nextInt();
            int k = reader.nextInt();

            int[] a = new int[n];
            for (int ai = 0; ai < n; ai++) {
                a[ai] = reader.nextInt();
            }

            int res = 0;
            for (int start = 0; start < n; start++) {
                List<Integer> list = new ArrayList<Integer>() {
                    @Override
                    public boolean add(Integer i) {
                        int index = Collections.binarySearch(this, i);
                        if (index < 0) {
                            index = ~index;
                        }
                        super.add(index, i);
                        return true;
                    }
                };

                int[] occurrence = new int[2001];
                for (int end = start; end < n; end++) {

                    list.add(a[end]);

                    occurrence[a[end]]++;

                    int subarrayLen = end - start + 1;

                    int m = (int) Math.ceil((double) k / subarrayLen);

                    int xi = (k - 1) / m;

                    int x = list.get(xi);

                    int f = occurrence[x];

                    if (f < 2001 && occurrence[f] > 0) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }

        reader.close();
    }

}
