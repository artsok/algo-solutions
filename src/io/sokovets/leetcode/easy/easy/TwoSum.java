package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};
        int target = 6;
        int[] ints = new TwoSum().twoSum(nums, target);
        System.out.println(ints);
    }

    public int[] twoSumCorrect(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)
                    && map.get(complement) != i) { //Проверяем, что не равен текущему индексу
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { //O(N)
            values.put(i, nums[i]); //O(1)
        }

        int[] result = null;
        for (int i = 0; i <= nums.length; i++) { //O(N)  //Итерируемся по всем значениям которые есть в мапе
            int rv = target - nums[i]; //получаем число, которое надо найти в мапе
            values.remove(i); //удаляем клюя, который итерируем
            if (values.containsValue(rv)) { //O(1) //если мапа содержит значение, которое надо найти
                for (Map.Entry<Integer, Integer> it : values.entrySet()) { //итерируемся по всей мапе ключу и значением
                    if (it.getValue().equals(rv)) { //если значение равняется то что нам нужно найти
                        result = new int[] {i, it.getKey()};
                    }
                }
                break;
            }
        }
        return result;
    }

}
