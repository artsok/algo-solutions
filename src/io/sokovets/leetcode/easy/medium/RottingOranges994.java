package io.sokovets.leetcode.easy.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * Medium
 *
 * 6611
 *
 * 272
 *
 * Add to List
 *
 * Share
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottingOranges994 {


    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCnt = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
                if (grid[r][c] == 1) {
                    freshCnt++;
                }
            }
        }
        int minute = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty() && freshCnt > 0) {
            // 3 - [x,y,z,null,x1,x2,x3,x4,y1,]
            for (int i = q.size(); i >= 1; i--) {
                int[] point = q.poll();
                for (int[] direction : directions) {
                    int newR = point[0] + direction[0];
                    int newC = point[1] + direction[1];
                    if (newR >= 0 && newR < ROWS && newC >= 0 && newC < COLS) {
                        if (grid[newR][newC] == 1) {
                            q.add(new int[]{newR, newC});
                            grid[newR][newC] = 2;
                            freshCnt--;
                        }
                    }
                }
            }
            minute++;
        }
        if (freshCnt != 0) {
            return -1;
        }
        return minute;
    }
}
