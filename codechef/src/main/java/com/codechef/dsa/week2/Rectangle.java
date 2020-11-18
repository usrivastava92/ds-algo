package com.codechef.dsa.week2;


import java.util.*;

public class Rectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();
        long maxY = 500;
        long maxX = 100000;
        Map<Point, Point> forwardDist = new HashMap<>();
        Map<Point, Point> backwardDist = new HashMap<>();
        long maxArea = -1;
        Stack<Point> stack1 = new Stack<>();

        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            Point point = new Point(x, y);
            points.add(point);
        }

        Collections.sort(points);

        Stack<Point> stack = new Stack<>();

        long prev = 0;
        for (int i = 0; i < n; i++) {
            Point point = points.get(i);

            while (!stack.isEmpty() && stack.peek().y > point.y) {
                forwardDist.put(stack.pop(), point);
            }
            stack.push(point);

            while (!stack1.empty() && stack1.peek().y >= point.y) {
                stack1.pop();
            }
            if (!stack1.empty()) {
                backwardDist.put(point, stack1.peek());
            }
            stack1.push(point);


            long area = (point.x - prev) * maxY;
            if (area > maxArea) {
                maxArea = area;
            }
            prev = point.x;
        }

        long area = (maxX - prev) * maxY;
        if (area > maxArea) {
            maxArea = area;
        }

        Point backwardDefault = new Point(0, 0);
        Point forwardDefault = new Point(maxX, 0);

        for (int i = 0; i < n; i++) {
            Point point = points.get(i);
            long temp = (maxX - point.x) * 500;
            if (temp <= maxArea) {
                break;
            }
            long backward = point.x - backwardDist.getOrDefault(point, backwardDefault).x;
            long forward = forwardDist.getOrDefault(point, forwardDefault).x - point.x;
            area = (backward + forward) * point.y;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        System.out.println(maxArea);
        sc.close();
    }
}

class Point implements Comparable<Point> {
    final long x;
    final long y;

    public Point(long x, long y) {
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
    public int compareTo(Point o) {
        return Long.compare(this.x, o.x);
    }
}