package com.leet.daysofcode.may.week1;


public class FirstBadVersion {

    private int firstBad;

    private FirstBadVersion(int firstBad) {
        this.firstBad = firstBad;
    }

    public static void main(String[] args) {
        int size = 2126753390;
        int firstBad = 1702766719;
        FirstBadVersion firstBadVersion = new FirstBadVersion(firstBad);
        System.out.println(firstBadVersion.firstBadVersion(size));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            System.out.println(low + " : " + high);
            int mid = low + (high - low) / 2;
            boolean isBad = isBadVersion(mid);
            if (mid == low) {
                if (isBad) {
                    return low;
                } else if (isBadVersion(high)) {
                    return high;
                }
                break;
            }
            if (isBad) {
                high = mid;

            } else {
                low = mid;
            }
        }
        return -1;
    }


    private boolean isBadVersion(int n) {
        if (n >= firstBad) {
            return true;
        }
        return false;
    }

}
