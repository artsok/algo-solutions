package io.sokovets.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example:
 * <p>
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return
 * <p>
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * <p>
 * <p>
 * [
 * * [ 1, 2, 3, 4 ],
 * * [ 5, 6, 7, 8 ],
 * * [ 9, 10, 11, 12],
 * * [ 13, 14, 15, 16]
 * * ]
 * <p>
 * You should return [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 * <p>
 * Problem Approach :
 * <p>
 * VIDEO : https://www.youtube.com/watch?v=siKFOI8PNKM
 * <p>
 * Complete solution in the hints.
 */
public class SpiralOrderMatrixI {
    public static void main(String[] args) {
        List<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(5);
        arrayList2.add(6);
        arrayList2.add(7);
        arrayList2.add(8);
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(9);
        arrayList3.add(10);
        arrayList3.add(11);
        arrayList3.add(12);

        ArrayList<Integer> arrayList4 = new ArrayList<>();
        arrayList4.add(13);
        arrayList4.add(14);
        arrayList4.add(15);
        arrayList4.add(16);

        a.add(arrayList1);
        a.add(arrayList2);
        a.add(arrayList3);
        a.add(arrayList4);

        System.out.println(new SpiralOrderMatrixI().spiralOrder(a));
    }

    //(m rows, n columns)
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int ROWS = A.size();
        int COLS = A.get(0).size();
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        int marker = -1;

        int[][] lastPoint = new int[][]{{0, 0}}; //lastPoint[0][0] = индекс строчки, lastPoint[0][1] = индекс столбца
        ArrayList<Integer> list = new ArrayList<>();

        while (count != COLS * ROWS) {
            for (int direction[] : directions) {
                int x = direction[0];
                int y = direction[1];

                if (x == 0 && y == 1) { //Вправо {0,1}
                    for (int k = 0; k < COLS; k++) {
                        int value = A.get(lastPoint[0][0]).get(k);
                        if (value != marker) {
                            list.add(value);
                            A.get(lastPoint[0][0]).set(k, marker); //Отмечаем, что были на этой позиции
                            lastPoint[0][1] = k; //Заносим индекс столбца где были
                            count++;
                        }
                    }
                }
                if (x == 1 && y == 0) {//Вниз {1,0}
                    for (int k = 0; k < ROWS; k++) {
                        int value = A.get(k).get(lastPoint[0][1]);
                        if (value != marker) {
                            list.add(value);
                            A.get(k).set(lastPoint[0][1], marker);
                            lastPoint[0][0] = k;
                            count++;
                        }

                    }
                }

                if (x == 0 && y == -1) {//Влево {0, -1}
                    for (int k = 1; k <= COLS; k++) {
                        int value = A.get(lastPoint[0][0]).get(COLS - k);
                        if (value != marker) {
                            list.add(value);
                            A.get(lastPoint[0][0]).set(COLS - k, marker);
                            lastPoint[0][1] = COLS - k;
                            count++;
                        }
                    }
                }

                if (x == -1 && y == 0) { //Вверх {-1,0}
                    for (int k = 1; k <= ROWS; k++) {
                        int value = A.get(ROWS - k).get(lastPoint[0][1]);
                        if (value != marker) {
                            list.add(value);
                            lastPoint[0][0] = ROWS - k;
                            A.get(ROWS - k).set(lastPoint[0][1], marker);
                            count++;
                        }
                    }
                }
            }
        }

        return list;
    }
}
