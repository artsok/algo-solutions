package io.sokovets.leetcode.easy.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    public int numIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int answer = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    answer++; //увеличили ответ

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{r, c}); //Добавляем кординату
                    grid[r][c] = 9;//Обозначаем, что тут были
                    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //Возможные наши направления (вниз, вверх, вправо, влево)
                    while (!queue.isEmpty()) { //пока наша очередь не пустая
                        int[] point = queue.poll(); //получаем кординату
                        int row = point[0]; //Кординаты х
                        int col = point[1]; //Кординаты y

                        //Перебор всех направлений
                        for (int[] direction : directions) {
                            int newRow = row + direction[0]; //от текущей позиции смотрим вверх, вниз и тд
                            int newCol = col + direction[1];


                            if (newRow < rows && newCol < cols) { //не выходим за граница массива. Так как ичпользуем суммирования направлений с текущими кординатами
                                if (newRow >= 0 && newCol >= 0) { //проверка, что индексы положительные. Нет индексов отрицательных.
                                    if (grid[newRow][newCol] == 1) {//Если по новым координатам у нас земля (1 это земля, остров) то идем дальше
                                        grid[newRow][newCol] = 9; //помечаем, что в этой точке были.
                                        queue.add(new int[]{newRow, newCol}); //добавляем новые кординаты в очередь
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return answer;
    }
}
