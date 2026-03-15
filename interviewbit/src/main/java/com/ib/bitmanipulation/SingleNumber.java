package com.ib.bitmanipulation;

import java.util.List;

public class SingleNumber {

  public int singleNumber(final List<Integer> A) {
    int num = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      num ^= A.get(i);
    }
    return num;
  }
}
