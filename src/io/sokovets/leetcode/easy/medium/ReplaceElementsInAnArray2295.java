package io.sokovets.leetcode.easy.medium;

import java.sql.SQLOutput;
import java.util.*;

/**
 * В этой задачи могут попадаться дублликаты в операциях (например операция начинается с [0,1],[0,1].
 *
 * You are given a 0-indexed array nums that consists of n distinct positive integers. Apply m operations to this array, where in the ith operation you replace the number operations[i][0] with operations[i][1].
 *
 * It is guaranteed that in the ith operation:
 *
 * operations[i][0] exists in nums.
 * operations[i][1] does not exist in nums.
 * Return the array obtained after applying all the operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]
 * Output: [3,2,7,1]
 * Explanation: We perform the following operations on nums:
 * - Replace the number 1 with 3. nums becomes [3,2,4,6].
 * - Replace the number 4 with 7. nums becomes [3,2,7,6].
 * - Replace the number 6 with 1. nums becomes [3,2,7,1].
 * We return the final array [3,2,7,1].
 * Example 2:
 *
 * Input: nums = [1,2], operations = [[1,3],[2,1],[3,2]]
 * Output: [2,1]
 * Explanation: We perform the following operations to nums:
 * - Replace the number 1 with 3. nums becomes [3,2].
 * - Replace the number 2 with 1. nums becomes [3,1].
 * - Replace the number 3 with 2. nums becomes [2,1].
 * We return the array [2,1].
 */
public class ReplaceElementsInAnArray2295 {

    public static void main(String[] args) {

        //На этом кейсе у меня не проходило
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
        int[][] operations = new int[][]{{100, 101}, {99, 100}, {98, 99}, {97, 98}, {96, 97}, {95, 96}, {94, 95}, {93, 94}, {92, 93}, {91, 92}, {90, 91}, {89, 90}, {88, 89}, {87, 88}, {86, 87}, {85, 86}, {84, 85}, {83, 84}, {82, 83}, {81, 82}, {80, 81}, {79, 80}, {78, 79}, {77, 78}, {76, 77}, {75, 76}, {74, 75}, {73, 74}, {72, 73}, {71, 72}, {70, 71}, {69, 70}, {68, 69}, {67, 68}, {66, 67}, {65, 66}, {64, 65}, {63, 64}, {62, 63}, {61, 62}, {60, 61}, {59, 60}, {58, 59}, {57, 58}, {56, 57}, {55, 56}, {54, 55}, {53, 54}, {52, 53}, {51, 52}, {50, 51}, {49, 50}, {48, 49}, {47, 48}, {46, 47}, {45, 46}, {44, 45}, {43, 44}, {42, 43}, {41, 42}, {40, 41}, {39, 40}, {38, 39}, {37, 38}, {36, 37}, {35, 36}, {34, 35}, {33, 34}, {32, 33}, {31, 32}, {30, 31}, {29, 30}, {28, 29}, {27, 28}, {26, 27}, {25, 26}, {24, 25}, {23, 24}, {22, 23}, {21, 22}, {20, 21}, {19, 20}, {18, 19}, {17, 18}, {16, 17}, {15, 16}, {14, 15}, {13, 14}, {12, 13}, {11, 12}, {10, 11}, {9, 10}, {8, 9}, {7, 8}, {6, 7}, {5, 6}, {4, 5}, {3, 4}, {2, 3}, {1, 2}, {101, 1}, {100, 101}};

        System.out.println(Arrays.toString(new ReplaceElementsInAnArray2295().arrayChange(nums, operations)));
    }

    public int[] arrayChange(int[] nums, int[][] operations) {

        /**
         1. Move operations array to LinkedHashMap (key, value). Example [[1,3],[4,7],[6,1]] => {1,3},{4,7},{6,1}. I use the LinkedList to save order of operations
         2. Nums move to LinkedHashSet.
         3. Iterate operations over the LinkedHashSet
         4. Init new array and return it

         TimeComplexity = O(N)
         SpaceComlexity = O(N)
         **/


        /**
         *  Идея взять завести мапу: число - индекс
         *  Завести мапу операции: число которое, надо найти и число, которое надо поменять
         *  Далее идем по порядку операций, находим число в мапе и меняем ключ на новое значение
         */

        //[1,2,7,6]
        //{1-3},{4-7},{6-7},{4-5}
        //K = 0.


        /**
         * [1,2,4,6]
         * [[1,3],[4,7],[6, 999]]
         */

        //Заполняем мапу операциями
        Map<Integer, int[]> mapOfOperations = new LinkedHashMap<>();
            for (int i = 0; i < operations.length; i++) {
            mapOfOperations.put(i, operations[i]);
        }


        //Заполняем массив (число - его индекс)
        Map<Integer, Integer> arrayWithIndexes = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            arrayWithIndexes.put(nums[i], i);
        }

        //Идем по операциям и применяем их к массиву
        for (Map.Entry<Integer, int[]> entry : mapOfOperations.entrySet()) {
            int findValue = entry.getValue()[0];
            if (arrayWithIndexes.containsKey(findValue)) {
                int index = arrayWithIndexes.get(findValue);
                arrayWithIndexes.remove(findValue);
                arrayWithIndexes.put(entry.getValue()[1], index);
            }
        }

        //Формируем результирующий ответ
        for (Map.Entry<Integer, Integer> entry : arrayWithIndexes.entrySet()) {
            int value = entry.getKey();
            int index = entry.getValue();
            nums[index] = value;
        }

        return nums;
    }


    public int[] arrayChangeLC(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //Put all values in hashMap with their index
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        //Iterate over operation and find idx of index from map
        //update that index value with op[1];
        //again put value in map so that in future it help us when we have to update its value
        for(int[] op : operations){
            int idx = map.get(op[0]);
            nums[idx] = op[1];
            map.put(nums[idx],idx);
        }

        return nums;
    }
}

//