package io.sokovets.leetcode.easy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Вывести у каких индексов в массиве есть view side.
 */
public class BuildingsWithAnOceanView1762 {

    public static void main(String[] args) {
        int[] heights = {1, 3, 4, 5};
        System.out.println(new BuildingsWithAnOceanView1762().findBuildings(heights));
    }


    public int[] findBuildings(int[] heights) {
        //1, 3, 5, 1
        // ^
        //   ^

        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < heights.length; i++) {

            boolean flag = false; //

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] <= heights[j]) {

                    break; // У нас значение по индексу j больше чем значение по индексу i. Смысла проверять дальше нет
                }
            }

            if (!flag) {
                list.add(i); //Добавляем индекс элемента (тот индекс, который больше следующих элементов)
            }
        }

        int[] result = new int[list.size()];
        int index = 0;

        for (Integer rs : list) {
            result[0] = rs;
            index++;
        }
        return result;
    }
}