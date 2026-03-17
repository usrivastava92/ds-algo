package com.leet.ds.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountFancyNumbersInARange {

  public static class Solution {

    private static List<Long> goods = new ArrayList<>();
    private static final long MAX = 1_000_000_000_000_000L;

    private static void initGood() {
      if (!goods.isEmpty()) return;
      buildInc(0, 1);
      buildDec(0, 9);
      dedupe();
    }

    private static void buildInc(long num, int lastDigit) {
      if (num > MAX) {
        return;
      }
      goods.add(num);
      for (int i = lastDigit; i < 10; i++) {
        buildInc((num * 10) + i, i + 1);
      }
    }

    private static void buildDec(long num, int lastDigit) {
      if (num > MAX) {
        return;
      }
      goods.add(num);
      for (int i = lastDigit; i > -1; i--) {
        buildDec((num * 10) + i, i - 1);
      }
    }

    private static void dedupe() {
      Collections.sort(goods);
      int len = goods.size();
      int low = 0;
      int high = 1;
      while (high < len) {
        var lval = goods.get(low);
        var hval = goods.get(high);
        if (!lval.equals(hval)) {
          low++;
          goods.set(low, hval);
        }
        high++;
      }
      low++;
      while (low < len) {
        goods.remove(goods.size() - 1);
        low++;
      }
    }

    private static int lIndex(long num, int l, int r) {
      int ans = r + 1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        long midVal = goods.get(mid);
        if (midVal >= num) {
          ans = mid;
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
      return ans;
    }

    private static int hIndex(long num, int l, int r) {
      int ans = l - 1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        long midVal = goods.get(mid);
        if (midVal <= num) {
          ans = mid;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return ans;
    }

    public long countFancy(long l, long r) {
      initGood();
      System.out.println(goods);
      return 1;
    }
  }
}
