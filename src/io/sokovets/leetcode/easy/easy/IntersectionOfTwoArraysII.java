package io.sokovets.leetcode.easy.easy;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {

    }



    public int[] intersectON_M(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) { //Трюк, делаем так что первый аргумент в функции всегда будет самый минимальный
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }


    //O(nlogN+mLogM)
    public int[] intersectOLog(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); //Отсортировали массив
        Arrays.sort(nums2); //Отсортировали массив


        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) { //Прерываемся как только один достиг предела
            if (nums1[i] < nums2[j]) { //Если j больше чем i, то двигаем поинтер у массива nums1
                ++i;
            } else if (nums1[i] > nums2[j]) { //Если i больше, то двигаем понтер j у массива nums2
                ++j;
            } else { //Если значения равны
                nums1[k++] = nums1[i++]; //запишет в тот же массив и потом заинкриментит k и i.
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    //Мое решение
    public int[] intersect(int[] nums1, int[] nums2) {

        //1. Подсчитали кол-во чисел и сколько раз они появляются
        Map<Integer, Integer> mapNums1 = new HashMap<>();
        for (int number : nums1) {
            mapNums1.merge(number, 1, Integer::sum);
        }

        //2. Подсчитали кол-во чисел и сколько раз они появляются в другом массиве
        Map<Integer, Integer> mapNums2 = new HashMap<>();
        for (int number : nums2) {
            mapNums2.merge(number, 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mapNums1.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (mapNums2.containsKey(key)) {
                int intersectionCount = Math.min(value, mapNums2.get(key));
                for (int i = 0; i < intersectionCount; i++) {
                    result.add(key);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
