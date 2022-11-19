package io.sokovets.leetcode.easy.easy;

import java.util.PriorityQueue;

/**
 * Given an array of points on the X-Y plane points where points[i] = [xi, yi],
 * return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
 */
public class LargestTriangleArea812 {

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        //int[][] points = new int[][]{{1, 0}, {0, 0}, {0, 1}};
        System.out.println(new LargestTriangleArea812().largestTriangleArea(points));
    }


    /**
     * Перебираем все точки по очереди.
     * Так как у нас три точки, то мы запускаем три цикла.
     * <p>
     * Первый цикл берет точку с индекса 0, второй цикл берет точку с индекса 1, третий цикл берет точку с индеком 2.
     * И посчитали по формуле https://math.semestr.ru/line/triangle.php площадь треугольника, где известны три точки.
     */
    public double largestTriangleArea(int[][] points) {
        double max = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {

                    int x1 = points[i][0];
                    int x2 = points[j][0];
                    int x3 = points[k][0];

                    int y1 = points[i][1];
                    int y2 = points[j][1];
                    int y3 = points[k][1];

                    max = Math.max(max, 0.5 * Math.abs(((x1 - x3) * (y2 - y3)) - ((x2 - x3) * (y1 - y3))));

                    //Формула для поиска площади треугольника, когда знакомы все стороны:
                    // (((x1-x3) * (y2 - y3)) - ((y1-y3) * (x2 - x3))) * 0,5 или все деленное на 1/2
                }
            }
        }

        return max;
    }

    //Не работает
    public double largestTriangleAreaNotWork(int[][] points) {


        //[[-50,10],[10,1],[1,0],[0,2],[2,0]]

        /**
         My algorithm:
         1) Iterate each point with each other
         2) Calculate max square
         3) Return max square (area)
         **/

        double maxArea = Double.MIN_VALUE;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        //<Отсортированы по x>
        //<Отсортированы по y>


        for (int[] point : points) {
            for (int[] point1 : points) {
                //sqrt((x1-x2)^2 + (y1-y2)^2)
                double line = Math.sqrt((point[0] - point1[0]) * (point[0] - point1[0]) + (point[1] - point1[1]) * (point[1] - point1[1]));
                pq.add((int) line);
            }
        }

        //Произведем рассчет "p – полупериметр треугольника". У нас треугольник который состоит из трех тощек.
        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();


        int p = (a + b + c) / 2;

        //Формула рассчета плошади
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return result;

    }

}
