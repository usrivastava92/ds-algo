package com.ib.strings;

public class MinimumCharactersRequiredToMakeStringPalindromic {

  public int solve(String A) {
    int start = 0;
    int end = 0;
    int count = 0;
    String copy = new StringBuilder(A).reverse().toString();
    while (true) {
      if (isPalin(copy.substring(start, end) + A)) break;
      end++;
      count++;
    }
    return count;
  }

  public boolean isPalin(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}
