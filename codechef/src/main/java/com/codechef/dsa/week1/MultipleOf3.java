package com.codechef.dsa.week1;

import com.codechef.utility.Reader;

import java.io.IOException;
import java.util.*;

public class MultipleOf3 {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();

        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            long k = reader.nextLong();
            long a = reader.nextLong();
            long b = reader.nextLong();
            long sum = a + b;
            if (k == 3) {
                sum += (sum % 10);
            } else if (k > 3) {
                Map<Long, Long> map = new HashMap<>();
                Map<Long, Long> sumMap = new HashMap<>();
                sumMap.put(2L, sum);
                long count = 3;
                long element = (sum % 10);
                while (!map.containsKey(element)) {
                    map.put(element, count);

                    sum += element;
                    sumMap.put(count, sum);

                    element = (element * 2) % 10;
                    count++;
                }
                long nonRepLen = map.get(element) - 1;
                long sumBefore = sumMap.get(nonRepLen);
                long repSum = sum - sumBefore;
                long repLen = count - map.get(element);
                long leftLen = k - nonRepLen;
                long digitRepSum = (leftLen / repLen) * repSum;
                long digitLeftAfterRep = leftLen % repLen;
                long sumOfLeftDigits = sumMap.get(map.get(element) + digitLeftAfterRep - 1) - sumBefore;
                sum = sumBefore + digitRepSum + sumOfLeftDigits;
            }
            if (sum % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        reader.close();
    }
}
