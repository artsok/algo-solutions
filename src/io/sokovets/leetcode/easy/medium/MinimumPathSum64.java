package io.sokovets.leetcode.easy.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.



Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 */
public class MinimumPathSum64 {

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        //System.out.println(new MinimumPathSum64().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        //System.out.println(new MinimumPathSum64().minPathSum(new int[][]{{1, 2, 5}, {3, 2, 1}}));


        //1 2 3
        //4 5 6

        //[[1,2,5]
        // [3,2,1]]
    }

    //Идея идти с конца, с последнего элемента многомерного массива.
    public int minPathSum(int[][] grid) {
        //int ROWS = grid.length;
        //int COLS = grid[0].length;

        //Определяем DP массив
        //int[][] dp = new int[ROWS][COLS];
        //Пойдем с конца, это означает, что идем с крайнего нижнего значения
        //Также сначала идем по колонкам потом по строкам

        int ROWS = grid.length;
        int COLS = grid[0].length;

        int dp[][] = new int[ROWS][COLS]; //Создаем DP массив, куда будем записывать данные от пред.вычислений

        for (int r = ROWS - 1; r >= 0; r--) {
            for (int c = COLS - 1; c >= 0; c--) {

                if (ROWS - 1 == r && COLS - 1 == c) { //Берем только последний правый элемент. Заносим его в DP
                    dp[r][c] = grid[r][c];
                }
                else if (c + 1 < COLS &&  r == ROWS - 1) { //Смотрим направо от элемента на котором стоим. Проходим до конца.
                    dp[r][c] = grid[r][c] + dp[r][c+1];
                } else if (r + 1 < ROWS && c == COLS - 1) { //Смотрим вниз от элемента нде стоим. Обратить внимание, что идем вниз только по крайней правой стороне
                    dp[r][c] = grid[r][c] + dp[r+1][c];
                } else {
                    dp[r][c] = grid[r][c] + Math.min(dp[r+1][c], dp[r][c+1]);
                }
            }
        }


        return dp[0][0];
    }


    //Не верное решение. не рассмотрел все варианты.
    public int minPathSum1(int[][] grid) {
        int[][] directions1 = {{0, 1}, {1, 0}}; //left,down
        int[][] directions2 = {{1, 0}, {0, 1}}; //down,left

        int rows = grid.length;
        int cols = grid[0].length;


        //System.out.println(grid[0][0]);
        //grid[0][0] = 999;


        Deque<int[]> qu = new ArrayDeque<>();
        qu.add(new int[]{0, 0});


        LinkedList<Integer> a = new LinkedList<>();
        a.add(grid[0][0]);
        a.add(grid[0][0]);

        int last = grid[grid.length - 1][grid[0].length - 1];


        while (!qu.isEmpty()) {

            int[] point = qu.pollFirst();

            int startPointX = point[0];
            int startPointY = point[1];

            //for (int i = 0; int j =0; i,j < steps; i++;j++ )

            for (int[] direction1 : directions1) {

                int newPointX = startPointX + direction1[0];
                int newPointY = startPointY + direction1[1];


                //Row = 0, Col = Max
                //Cols = 0, Row = MAX

                if (newPointX < rows && newPointY < cols && newPointX >= 0 && newPointY >= 0) {
                    if (newPointX == 0 || newPointY == 0 || newPointX == (rows - 1) || newPointY == (cols - 1)) {
                        if (grid[newPointX][newPointY] != 999) {


                            a.add(grid[newPointX][newPointY]);

                            //System.out.print(grid[newPointX][newPointY]);
                            qu.add(new int[]{newPointX, newPointY});

                            //minPathSum1 += grid[newPointX][newPointY];
                            grid[newPointX][newPointY] = 999;
                        }

                    }
                }

            }


        }

        int minPath1 = 0;
        int minPath2 = 0;

        a.add(last);


        for (int i = 0; i < a.size(); i++) {
            if (i % 2 == 0) {
                minPath1 += a.get(i);
            } else {
                minPath2 += a.get(i);
            }
        }

        return Math.min(minPath1, minPath2);
    }

}
