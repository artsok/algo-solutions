package io.sokovets.leetcode.easy.medium;

import java.util.Arrays;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.
 * <p>
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * <p>
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePathsII_63 {

    public static void main(String[] args) {
        //int[][] obstacleGrid = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        //int[][] obstacleGrid = new int[][]{{1, 0}};
        int[][] obstacleGrid = new int[][]{{1}, {0}};
        System.out.println(new UniquePathsII_63().uniquePathsWithObstacles(obstacleGrid));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        //0. I use dp

        //1. based points:
        //2. Fill the top row by one. It's our unique path
        //3. Fill the left column by 1. It's our unique path
        //4. What we want to find: F[i] contains unique path
        //5. How to find F[i] = F[i, j - 1] + F[i, j - 1];
        //6. From what points would we start? i = 1,j = 1;
        //7. We have our obstacles. Check each points. If we in a cell where obstacle set to the F[i] = 0
        //8. Get result from F[i][j]


        int ROWS = obstacleGrid.length;
        int COLS = obstacleGrid[0].length;

        int[][] dp = new int[ROWS][COLS];

        boolean flag = true;

        //My based values for dp
        for (int i = 0; i < COLS; i++) {
            if (obstacleGrid[0][i] == 1 || !flag) {
                dp[0][i] = 0;
                flag = false;
            } else if (flag) {
                dp[0][i] = 1;
            }
        }

        flag = true;

        for (int i = 0; i < ROWS; i++) {
            //Ограничения. Сразу граничные значение вычисляем
            if (obstacleGrid[i][0] == 1 || !flag) {
                dp[i][0] = 0;
                flag = false;
            } else if (flag) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++)

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
        }

        return dp[ROWS - 1][COLS - 1];
    }


    public int uniquePathsWithObstaclesWithMemoization(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, obstacleGrid, dp);
    }

    int solve(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if (i < 0 || i >= obstacleGrid.length || j < 0 || j >= obstacleGrid[i].length || obstacleGrid[i][j] == 1)
            return 0;

        if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = solve(i + 1, j, obstacleGrid, dp) + solve(i, j + 1, obstacleGrid, dp);
    }
}
