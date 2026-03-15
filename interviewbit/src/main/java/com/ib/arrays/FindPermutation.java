package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindPermutation {

  public ArrayList<Integer> findPerm(final String A, int B) {
    ArrayList<Integer> ans = new ArrayList<>();
    if (B <= 1) {
      if (B == 1) {
        ans.add(1);
      }
      return ans;
    }
    int max = B;
    int min = 1;
    for (char ch : A.toCharArray()) {
      if (ch == 'I') {
        ans.add(min++);
      } else {
        ans.add(max--);
      }
    }
    if (A.charAt(B - 2) == 'I') {
      ans.add(min++);
    } else {
      ans.add(max--);
    }
    return ans;
  }

  static void verifyOutput(List<Integer> output, final String A, int B) {
    if (A.isEmpty() || output.isEmpty()) {
      return;
    }
    int last = output.get(0);
    for (int i = 0, len = B - 1; i < len; i++) {
      char ch = A.charAt(i);
      int curr = output.get(i + 1);
      if (ch == 'I') {
        if (curr <= last) {
          throw new RuntimeException("Invalid output");
        }
        last = curr;
      } else {
        if (curr >= last) {
          throw new RuntimeException("Invalid output");
        }
        last = output.get(i + 1);
      }
    }
  }
}
