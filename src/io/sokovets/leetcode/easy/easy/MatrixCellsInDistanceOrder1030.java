package io.sokovets.leetcode.easy.easy;

import java.util.*;

/**
 * You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
 * <p>
 * Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.
 * <p>
 * The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: rows = 1, cols = 2, rCenter = 0, cCenter = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (0, 0) to other cells are: [0,1]
 * Example 2:
 * <p>
 * Input: rows = 2, cols = 2, rCenter = 0, cCenter = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (0, 1) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 * Example 3:
 * <p>
 * Input: rows = 2, cols = 3, rCenter = 1, cCenter = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (1, 2) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= rows, cols <= 100
 * 0 <= rCenter < rows
 * 0 <= cCenter < cols
 */
public class MatrixCellsInDistanceOrder1030 {
    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new MatrixCellsInDistanceOrder1030().allCellsDistOrder(2, 3, 1, 2)));


    }

    //rows = строки, записываем их всегда в двухмерном массиве первыми
    //cols = столбцы, записываем их всегда вторыми в двухмерном массиве
    public int[][] allCellsDistOrder1(int rows, int cols, int rCenter, int cCenter) {
        int[][] matrix = new int[rows][cols];
        int[][] result = new int[cols * rows][];


        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{rCenter, cCenter});
        matrix[rCenter][cCenter] = 999;

        int index = 0;
        result[index] = new int[]{rCenter, cCenter};


        while (!queue.isEmpty()) {

            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //Возможные наши направления (вниз, вверх, вправо, влево)


            for (int[] direction : directions) {
                int newPointRow = row + direction[0];
                int newPointCol = col + direction[1];

                if (newPointCol < cols && newPointRow < rows && newPointCol >= 0 && newPointRow >= 0) {

                    if (matrix[newPointRow][newPointCol] != 999) {
                        matrix[newPointRow][newPointCol] = 999;
                        queue.add(new int[]{newPointRow, newPointCol});

                        //Запись в результат
                        index++;
                        result[index] = new int[]{newPointRow, newPointCol};
                    }
                }


            }
        }

        return result;


    }

    /**
     * Другое решение
     *
     * @param a
     * @param b
     * @param rCenter
     * @param cCenter
     * @return
     */

    public int compare(int[] a, int[] b, int rCenter, int cCenter) {
        int r1 = a[0];
        int c1 = a[1];

        int r2 = b[0];
        int c2 = b[1];

        //|r1 - r2| + |c1 - c2|
        int distance1 = Math.abs(rCenter - r1) + Math.abs(cCenter - c1); //-3
        int distance2 = Math.abs(rCenter - r2) + Math.abs(cCenter - c2); //-1 + 0 -4 = -5

        return Integer.compare(distance1, distance2);
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> compare(a, b, rCenter, cCenter)); //

        //rows = 2, cols = 3, rCenter = 1, cCenter = 2
        //Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]

        //0 1 2
        //1 1 X

        //[1,2],

        //[0,0],[0,1],[0,2], [1,0],[1,1] ->

        //[1,1],[0,2],[0,1],[1,0],[0,0]

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == rCenter && j == cCenter) {
                    continue;
                }
                pq.add(new int[]{i, j});
            }
        }

        int[][] result = new int[cols * rows][];
        result[0] = new int[] {rCenter, cCenter};
        int index = 1;

        while (!pq.isEmpty()) {
            result[index] = pq.poll();
            index++;
        }

        return result;
    }

}
