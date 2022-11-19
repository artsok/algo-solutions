package io.sokovets.leetcode.easy.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 */
public class PascalsTriangle118 {

    /**
     * My algorithm:
     * 0. N,M = length
     * 1. I know value from array[0][0] = 1; array[i][0] = 1; array[i][j++] = 0; I will fill these cells by '1'.
     * 2. I know formula: array[i][j] = array[i-1][j-1] + array[i-1][j]; I will iterate in 2D-Matrix. i,j (ROW,COL)
     * 3.I will fill the List<List<Integer>>. Skip '0' number
     **/

    public List<List<Integer>> generate(int numRows) {
        int[][] array = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            array[i][0] = 1;
        }

        for (int i = 0; i < numRows; i++) {
            array[i][i] = 1;
        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {

                //Recurrence Relation
                array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                list.add(array[i][j]);
            }
            result.add(list);
        }

        return result;
    }
}
