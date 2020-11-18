package com.ib.arrays;

import java.util.Arrays;
import java.util.List;

public class Maxspprod {

    public static void main(String... args) {
        Integer[] arrivals = new Integer[]{17, 0, 45, 11, 16, 43, 15, 42, 2, 41, 0, 27, 37, 25, 17, 42, 24, 23, 11, 4, 29, 39, 6, 10, 42, 16, 17, 39, 1};
        Maxspprod maxspprod = new Maxspprod();
        System.out.println(maxspprod.maxSpecialProduct(Arrays.asList(arrivals)));
    }


    public int maxSpecialProduct(List<Integer> A) {
        Long max = Long.MIN_VALUE;
        int size = A.size();
        Integer leftLargest = null;
        Integer rightLargest = null;
        for (int i = 0; i < size; i++) {
            if (i - 1 > -1) {
                Integer currentLeft = A.get(i - 1);
                if (leftLargest == null) {
                    leftLargest = currentLeft;
                } else {
                    if (leftLargest < currentLeft) {
                        leftLargest = currentLeft;
                    }
                }
            }
            if (i + 1 < size) {
                Integer currentRight = A.get(i + 1);
                if (rightLargest == null) {
                    rightLargest = currentRight;
                } else {
                    if (rightLargest < currentRight) {
                        rightLargest = currentRight;
                    }
                }
            }
            Long spVal = 0L;
            if (rightLargest == null || leftLargest == null) {
            } else {
                spVal = new Long(rightLargest) * new Long(leftLargest);
            }
            if (spVal > max) {
                max = spVal;
            }
        }
        return new Long(max % 1000000007).intValue();
    }

    public Long maxSpProd(List<Integer> arr, int index, int size) {
        Long leftMax = null;
        Long rightMax = null;
        Integer currElement = arr.get(index);
        int i = index + 1;
        while (i < size) {
            if (currElement < arr.get(i)) {
                rightMax = new Long(arr.get(i));
                break;
            }
            i++;
        }

        int j = index - 1;
        while (j > -1) {
            if (currElement < arr.get(j)) {
                leftMax = new Long(arr.get(j));
                break;
            }
            j--;
        }
        if (leftMax == null || rightMax == null) {
            return 0L;
        }
        return leftMax * rightMax;
    }

}
