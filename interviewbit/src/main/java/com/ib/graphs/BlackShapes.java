package com.ib.graphs;

public class BlackShapes {

    public int black(String[] A) {
        if (A == null || A.length == 0 || A[0].length() == 0) {
            return 0;
        }
        char[][] chars = new char[A.length][];
        for (int i = 0; i < A.length; i++) {
            chars[i] = A[i].toCharArray();
        }
        int n = A.length;
        int m = chars[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == 'X') {
                    ans++;
                    dfs(chars, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] chars, int i, int j) {
        if (i < 0 || i >= chars.length || j < 0 || j >= chars[0].length || chars[i][j] == 'O') {
            return;
        }
        chars[i][j] = 'O';
        dfs(chars, i + 1, j);
        dfs(chars, i - 1, j);
        dfs(chars, i, j + 1);
        dfs(chars, i, j - 1);
    }


}
