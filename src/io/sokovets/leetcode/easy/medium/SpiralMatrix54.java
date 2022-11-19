package io.sokovets.leetcode.easy.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int count = 0;
        int marker = -101;
        List<Integer> result = new ArrayList();

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[][] lastPoint = new int[][]{{0,0}};

        while(ROWS*COLS != count) {
            for (int[] direction : directions) {
                int pointX = direction[0];
                int pointY = direction[1];

                if (pointX == 0 && pointY == 1) {
                    for (int i = 0; i < COLS; i++) {
                        int value = matrix[lastPoint[0][0]][i];
                        if (value != marker) {
                            matrix[lastPoint[0][0]][i] = marker;
                            result.add(value);
                            lastPoint[0][1] = i;
                            count++;
                        }
                    }
                }
                if (pointX == 1 && pointY == 0) {
                    for (int i = 0; i < ROWS; i++) {
                        int value = matrix[i][lastPoint[0][1]];
                        if (value != marker) {
                            matrix[i][lastPoint[0][1]] = marker;
                            result.add(value);
                            lastPoint[0][0] = i;
                            count++;
                        }
                    }
                }
                if (pointX == 0 && pointY == -1) {
                    for (int i = 1; i <= COLS; i++) {
                        int value = matrix[lastPoint[0][0]][COLS-i];
                        if (value != marker) {
                            matrix[lastPoint[0][0]][COLS - i] = marker;
                            result.add(value);
                            lastPoint[0][1] = COLS - i;
                            count++;
                        }
                    }
                }
                if (pointX == -1 && pointY == 0) {
                    for (int i = 1; i <= ROWS; i++) {
                        int value = matrix[ROWS-i][lastPoint[0][1]];
                        if (value != marker) {
                            matrix[ROWS-i][lastPoint[0][1]] = marker;
                            result.add(value);
                            lastPoint[0][0] = ROWS - i;
                            count++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
