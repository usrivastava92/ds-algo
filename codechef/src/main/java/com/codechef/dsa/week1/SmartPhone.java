package com.codechef.dsa.week1;

import com.codechef.utility.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartPhone {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        List<Long> budgets = new ArrayList<>();
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            budgets.add(reader.nextLong());
        }
        Collections.sort(budgets, Collections.reverseOrder());
        long max = -1;
        for (int i = 0; i < n; i++) {
            long temp = budgets.get(i) * (i + 1);
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
        reader.close();
    }


}
