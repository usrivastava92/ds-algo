package com.codechef.dsa.week3;

import com.codechef.utility.Reader;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Fencing {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testcaseCount = reader.nextInt();

        while (testcaseCount-- > 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int k = reader.nextInt();

            Set<Point> pointSet = new HashSet<>();

            for (int i = 0; i < k; i++) {
                int x = reader.nextInt();
                int y = reader.nextInt();
                pointSet.add(new Point(x, y));
            }

            int fence = 0;
            for (Point point : pointSet) {
                int i = point.x;
                int j = point.y;
                int x, y;
                x = i + 1;
                if (x > n || !pointSet.contains(new Point(x, j))) {
                    fence++;
                }
                x = i - 1;
                if (x < 1 || !pointSet.contains(new Point(x, j))) {
                    fence++;
                }
                y = j + 1;
                if (y > m || !pointSet.contains(new Point(i, y))) {
                    fence++;
                }
                y = j - 1;
                if (y < 1 || !pointSet.contains(new Point(i, y))) {
                    fence++;
                }
            }

            System.out.println(fence);

        }
        reader.close();
    }
}

class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
