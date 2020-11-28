package com.ib.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaysToColorA3NBoard {

    public static void main(String[] args) {
        int[] inputs = {1, 2, 6};
        int[] outputs = {36, 588, 41999148};
        WaysToColorA3NBoard waysToColorA3NBoard = new WaysToColorA3NBoard();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + waysToColorA3NBoard.solve(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("##############################################");
        }
    }

    public int solve(int A) {
        Map<Triplet, Integer>[] box = new HashMap[2];
        for (int i = 0; i <= 1; i++) {
            box[i] = new HashMap<>();
        }
        List<Triplet> all = Triplet.generateAllValidSingleTriple();
        int j = 0;
        for (int i = 1; i <= A; i++) {
            if (i == 1) {
                for (Triplet triplet : all) {
                    box[j].put(triplet, 1);
                }
            } else {
                j = (j + 1) % 2;
                for (Triplet current : all) {
                    int sum = 0;
                    for (Triplet prev : all) {
                        if (current.isValid(prev)) {
                            sum = (sum + box[(j + 1) % 2].get(prev)) % 1000000007;

                        }
                    }
                    box[j].put(current, sum);
                }
            }
        }
        int sum = 0;
        for (Integer trp : box[(A + 1) % 2].values()) {
            sum = (sum + trp) % 1000000007;
        }
        return sum;
    }
}

class Triplet {
    int a, b, c;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Triplet)) {
            return false;
        }

        Triplet triplet = (Triplet) o;

        if (a != triplet.a || b != triplet.b) {
            return false;
        }
        return c == triplet.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    public Triplet(int a, int b, int c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isValid(Triplet other) {
        return other.a != a && b != other.b && c != other.c;
    }

    @Override
    public String toString() {
        return "{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    public static List<Triplet> generateAllValidSingleTriple() {
        List<Triplet> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        if (k != j) {
                            ans.add(new Triplet(i, j, k));
                        }
                    }
                }
            }
        }
        return ans;
    }
}
