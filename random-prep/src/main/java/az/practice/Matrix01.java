package az.practice;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

public class Matrix01 {


    public static void main(String[] args) {
        int[][][] inputs = {{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}}, {{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}}};
        int[][][] outputs = {{{0, 0, 1, 0, 1, 2, 1, 0, 1, 2}, {1, 1, 2, 1, 0, 1, 1, 1, 2, 3}, {2, 1, 2, 1, 1, 0, 0, 0, 1, 2}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 2}, {0, 0, 1, 1, 1, 0, 1, 1, 2, 3}, {1, 0, 1, 2, 1, 1, 1, 2, 1, 2}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 2}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 2, 1, 0}}};
        Matrix01 matrix01 = new Matrix01();
        ArrayUtils.printArr(inputs[2]);
        System.out.println("#######################");
        ArrayUtils.printArr(outputs[0]);
        System.out.println("#######################");
        ArrayUtils.printArr(matrix01.updateMatrix(inputs[2]));
        Assert.assertArrayEquals(outputs[0],matrix01.updateMatrix(inputs[2]));
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[][]{{}};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = minDist(matrix, i, j);
            }
        }
        return ans;
    }


    public int minDist(int[][] m, int i, int j) {
        if (m[i][j] == 0) {
            return 0;
        }
        int dist = 0;
        while (i + dist < m.length && i - dist > -1 && j + dist < m[0].length && j - dist > -1) {
            if (m[i + dist][j] == 0 || m[i - dist][j] == 0 || m[i][j + dist] == 0 || m[i][j - dist] == 0) {
                return dist;
            }
            dist++;
        }
        int temp = dist;
        int ans = Integer.MAX_VALUE;
        while (i + temp < m.length) {
            if (m[i + temp][j] == 0) {
                ans = Math.min(temp, ans);
            }
            temp++;
        }
        temp = dist;
        while (i - temp > -1 && temp < ans) {
            if (m[i - temp][j] == 0) {
                ans = Math.min(temp, ans);
            }
            temp++;
        }
        temp = dist;
        while (j + temp < m[0].length && temp < ans) {
            if (m[i][j + temp] == 0) {
                ans = Math.min(temp, ans);
            }
            temp++;
        }
        temp = dist;
        while (j - temp > -1 && temp < ans) {
            if (m[i][j - temp] == 0) {
                ans = Math.min(temp, ans);
            }
            temp++;
        }
        return ans;
    }

}
