package io.sokovets.codility;

public class BrushStrokes {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        System.out.println(new BrushStrokes().solution(a));
    }

    public int solution(int[] A) {
        int[][] matrix = new int[A.length][5];

        int brushCount = 0;

        for (int i = 0; i < A.length; i++) {
            int height = A[i];
            for (int j = 0; j < height; j++) {
                matrix[i][j] = 1;
            }
        }




        return 0;
    }


}
