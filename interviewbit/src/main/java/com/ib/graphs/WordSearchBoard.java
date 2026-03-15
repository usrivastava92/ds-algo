package com.ib.graphs;

public class WordSearchBoard {

  public int exist(String[] A, String B) {
    if (A == null || A.length == 0 || A[0].isEmpty()) {
      return 0;
    }
    int wordLen = B.length();
    int n = A.length;
    int m = A[0].length();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (B.charAt(0) == A[i].charAt(j) && find(A, i, j, 0, n, m, wordLen, B)) {
          return 1;
        }
      }
    }
    return 0;
  }

  private boolean find(
      final String[] A,
      int i,
      int j,
      int charIndex,
      final int n,
      final int m,
      final int wordLen,
      final String word) {
    if (i >= n
        || i < 0
        || j >= m
        || j < 0
        || charIndex >= wordLen
        || A[i].charAt(j) != word.charAt(charIndex)) {
      return false;
    }
    if (charIndex == wordLen - 1) {
      return true;
    }
    boolean a = find(A, i + 1, j, charIndex + 1, n, m, wordLen, word);
    boolean b = find(A, i - 1, j, charIndex + 1, n, m, wordLen, word);
    boolean c = find(A, i, j + 1, charIndex + 1, n, m, wordLen, word);
    boolean d = find(A, i, j - 1, charIndex + 1, n, m, wordLen, word);
    return a || b || c || d;
  }
}
