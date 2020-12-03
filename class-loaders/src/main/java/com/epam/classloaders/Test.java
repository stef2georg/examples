package com.epam.classloaders;

public class Test {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Figure f = new Figure(p);
    }

    static class Figure {
        Point startPoint;

        Figure(Point startPoint) {
            this.startPoint = startPoint;
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
