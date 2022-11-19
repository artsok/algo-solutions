package io.sokovets.leetcode.easy.medium;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage48 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage48().rotate(test);
    }

    public void rotate(int[][] matrix) {
        //1. Представить как одномерный массив. Сделать сдвин на K, где K это у нас размер матрицы. Далее обратно загнать в массив 2D

        int n = matrix.length;
        int m = matrix[0].length;

        //Original
        //[1,2,3]
        //[4,5,6]
        //[7,8,9]

        //Swap (i,j) -> (j,i)

        //matrix[0][0]

        //[1,2,3]
        //[4,5,6]
        //[7,8,9]


        //Using 0
        ////Using 1


        //[1,4,7] (reverse)     [7,4,1]
        //[2,5,8]     ->        [8,5,2]
        //[3,6,9]               [9,6,3]


        int swapedIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i >= swapedIndex && j >= swapedIndex) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            swapedIndex++;
        }

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = m - 1;
            while (l < r) {
                int temp = matrix[i][r];
                matrix[i][r] = matrix[i][l];
                matrix[i][l] = temp;
                l++;
                r--;
            }
        }

    }
}
