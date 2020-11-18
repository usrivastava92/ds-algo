package com.leet.ds.array;

import com.ds.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QueensThatCanAttackTheKing {

    public static void main(String[] args) {
        int[][][] queens = {{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, {{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}}, {{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}}};
        int[][] kings = {{0, 0}, {3, 3}, {3, 4}};
        int[][][] outputs = {{{0, 1}, {1, 0}, {3, 3}}, {{2, 2}, {3, 4}, {4, 4}}, {{2, 3}, {1, 4}, {1, 6}, {3, 7}, {4, 3}, {5, 4}, {4, 5}}};
        QueensThatCanAttackTheKing queensThatCanAttackTheKing = new QueensThatCanAttackTheKing();
        for (int i = 0; i < queens.length; i++) {
            System.out.println("Queens -> " + ArrayUtils.toString(queens[i]));
            System.out.println("King -> " + Arrays.toString(kings[i]));
            List<List<Integer>> output = queensThatCanAttackTheKing.queensAttackTheKing(queens[i], kings[i]);
            Collections.sort(output, (x, y) -> {
                int comp = Integer.compare(x.get(0), y.get(0));
                if (comp == 0) {
                    return Integer.compare(x.get(1), y.get(1));
                }
                return comp;
            });
            ArrayUtils.standardSort2dArray(outputs[i]);
            System.out.println("Output -> " + output);
            System.out.println("Expected -> " + ArrayUtils.toString(outputs[i]));
            System.out.println("#########################################################");
        }
    }

    public List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] hf = null;
        int[] hb = null;
        int[] vf = null;
        int[] vb = null;
        int[] fdf = null;
        int[] fdb = null;
        int[] bdf = null;
        int[] bdb = null;

        for (int[] queen : queens) {
            boolean hfTemp = hf(queen, king);
            boolean hbTemp = hb(queen, king);
            boolean vfTemp = vf(queen, king);
            boolean vbTemp = vb(queen, king);
            boolean fdfTemp = fdf(queen, king);
            boolean fdbTemp = fdb(queen, king);
            boolean bdfTemp = bdf(queen, king);
            boolean bdbTemp = bdb(queen, king);
            //System.out.println(Arrays.toString(queen) + " -> " + hfTemp+"("+Arrays.toString(hf)+")" + " : " + hbTemp + " : " + vfTemp + " : " + vbTemp + " : " + fdfTemp + " : " + fdbTemp + " : " + bdfTemp + " : " + bdbTemp);
            if (hfTemp || hbTemp || vfTemp || vbTemp || fdfTemp || fdbTemp || bdfTemp || bdbTemp) {
                if (hfTemp && (hf == null || (queen[1] - king[1] < hf[1] - king[1]))) {
                    hf = queen;
                }
                if (hbTemp && (hb == null || (king[1] - queen[1] < king[1] - hb[1]))) {
                    hb = queen;
                }
                if (vfTemp && (vf == null || (queen[0] - king[0] < vf[0] - king[0]))) {
                    vf = queen;
                }
                if (vbTemp && (vb == null || (king[0] - queen[0] < king[0] - vb[0]))) {
                    vb = queen;
                }
                if (fdfTemp && (fdf == null || (queen[0] - king[0] < fdf[0] - king[0]))) {
                    fdf = queen;
                }
                if (fdbTemp && (fdb == null || (king[0] - queen[0] < king[0] - fdb[0]))) {
                    fdb = queen;
                }
                if (bdfTemp && (bdf == null || (king[1] - queen[1] < king[1] - bdf[1]))) {
                    bdf = queen;
                }
                if (bdbTemp && (bdb == null || (queen[1] - king[1] < bdb[1] - king[1]))) {
                    bdb = queen;
                }
            }
        }
        if (hf != null) {
            List<Integer> point = new ArrayList<>();
            point.add(hf[0]);
            point.add(hf[1]);
            ans.add(point);
        }
        if (hb != null) {
            List<Integer> point = new ArrayList<>();
            point.add(hb[0]);
            point.add(hb[1]);
            ans.add(point);
        }
        if (vf != null) {
            List<Integer> point = new ArrayList<>();
            point.add(vf[0]);
            point.add(vf[1]);
            ans.add(point);
        }
        if (vb != null) {
            List<Integer> point = new ArrayList<>();
            point.add(vb[0]);
            point.add(vb[1]);
            ans.add(point);
        }
        if (fdf != null) {
            List<Integer> point = new ArrayList<>();
            point.add(fdf[0]);
            point.add(fdf[1]);
            ans.add(point);
        }
        if (fdb != null) {
            List<Integer> point = new ArrayList<>();
            point.add(fdb[0]);
            point.add(fdb[1]);
            ans.add(point);
        }
        if (bdf != null) {
            List<Integer> point = new ArrayList<>();
            point.add(bdf[0]);
            point.add(bdf[1]);
            ans.add(point);
        }
        if (bdb != null) {
            List<Integer> point = new ArrayList<>();
            point.add(bdb[0]);
            point.add(bdb[1]);
            ans.add(point);
        }
        return ans;
    }

    private boolean hf(int[] queen, int[] king) {
        return queen[0] == king[0] && queen[1] - king[1] > 0;
    }

    private boolean hb(int[] queen, int[] king) {
        return queen[0] == king[0] && queen[1] - king[1] < 0;
    }

    private boolean vf(int[] queen, int[] king) {
        return queen[1] == king[1] && queen[0] - king[0] > 0;
    }

    private boolean vb(int[] queen, int[] king) {
        return queen[1] == king[1] && queen[0] - king[0] < 0;
    }

    private boolean fdf(int[] queen, int[] king) {
        return ((queen[0] - king[0]) == (queen[1] - king[1])) && (queen[0] - king[0] > 0);
    }

    private boolean fdb(int[] queen, int[] king) {
        return ((queen[0] - king[0]) == (queen[1] - king[1])) && (queen[0] - king[0] < 0);
    }

    private boolean bdf(int[] queen, int[] king) {
        return ((queen[0] - king[0]) == (king[1] - queen[1])) && (king[1] - queen[1] > 0);
    }

    private boolean bdb(int[] queen, int[] king) {
        return ((queen[0] - king[0]) == (king[1] - queen[1])) && (king[1] - queen[1] < 0);
    }
}
