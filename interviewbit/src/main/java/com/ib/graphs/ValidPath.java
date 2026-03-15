package com.ib.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ValidPath {

  public String solve(int A, int B, int C, int D, int[] E, int[] F) {
    Queue<int[]> queue = new ArrayDeque<>();
    int[][] visited = new int[A + 1][B + 1];
    for (int i = 0; i <= A; i++) {
      for (int j = 0; j <= B; j++) {
        for (int k = 0; k < C; k++) {
          if (isInside(E[k], F[k], D, i, j)) {
            visited[i][j] = -1; // INVALID point (i,j)
          }
        }
      }
    }
    if (visited[0][0] == -1 || visited[A][B] == -1) {
      return "NO";
    }
    queue.add(new int[] {0, 0});
    visited[0][0] = 1;
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int x = curr[0];
      int y = curr[1];
      if (x == A && y == B) {
        return "YES";
      }
      for (int i = 0; i < 8; i++) {
        int a = x + dx[i];
        int b = y + dy[i];
        if (isValid(a, b, A, B) && visited[a][b] == 0) {
          queue.add(new int[] {a, b});
          visited[a][b] = 1;
        }
      }
    }
    return "NO";
  }

  int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

  private boolean isValid(int x, int y, int N, int M) {
    return x >= 0 && x <= N && y >= 0 && y <= M;
  }

  private boolean isInside(int circle_x, int circle_y, int rad, int x, int y) {
    return (Math.pow((x - circle_x), 2) + Math.pow((y - circle_y), 2)) <= Math.pow(rad, 2);
  }
}
