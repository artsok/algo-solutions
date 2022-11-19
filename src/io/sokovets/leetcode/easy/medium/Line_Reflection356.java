package io.sokovets.leetcode.easy.medium;


import java.util.*;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[-1,1]]
 * Output: true
 * Example 2:
 * <p>
 * Input: [[1,1],[-1,-1]]
 * Output: false
 */
public class Line_Reflection356 {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {-1, 1}};
        Line_Reflection356 line_reflection356 = new Line_Reflection356();
        System.out.println(line_reflection356.solution(points));
    }

    public boolean solution(int[][] points) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] point : points) {

            if (map.containsKey(Arrays.hashCode(point))) { //contains возвращает false. даже если такой элемент есть
                map.remove(Arrays.hashCode(point));
                continue;
            }

            int x = point[0];
            int y = point[1];

            int[] invert = new int[]{-x, y};
            map.put(Arrays.hashCode(invert), invert);
        }
        return map.size() == 0;
    }
}
