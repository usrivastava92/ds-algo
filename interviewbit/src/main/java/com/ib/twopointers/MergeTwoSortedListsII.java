package com.ib.twopointers;

import java.util.ArrayList;

public class MergeTwoSortedListsII {

  public void merge(ArrayList<Integer> A, ArrayList<Integer> B) {
    int lenB = B.size();
    int j = 0;
    for (int i = 0; i < A.size(); i++) {
      if (j >= lenB) {
        break;
      }
      if (A.get(i) >= B.get(j)) {
        A.add(i--, B.get(j++));
      }
    }
    while (j < lenB) {
      A.add(B.get(j));
      j++;
    }
  }
}
