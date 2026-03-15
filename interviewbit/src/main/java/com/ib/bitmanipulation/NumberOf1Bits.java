package com.ib.bitmanipulation;

public class NumberOf1Bits {
  public int numSetBits(Long a) {
    return Long.toBinaryString(a).replaceAll("0", "").length();
  }
}
