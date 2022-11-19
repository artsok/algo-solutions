package io.sokovets.leetcode.easy.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        System.out.println(new SingleNumber136().singleNumber(new int[]{1, 2, 2, 3, 3}));
    }

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> mem = new HashMap<>();

        if (nums.length == 1) {
            return nums[0];
        }

        for (int num : nums) {
            mem.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : mem.entrySet()) {

            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /* Use XOR
    1. Когда используешь 4^4=0,число само на себя то получается ноль. ^ = XOR
    2. Заводишь переменную, Проходшь по всему массиву и туда записываешь значение num XOR result

*/
    public int singleNumberO1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^=num; //result = result ^ num;
        }
        return result;
    }




    //Еще можно решить через Arrays.sort
    public int singleNumber(int[] nums) {
        Arrays.sort(nums); //[1,1,2,2,4]

        int index = 0;
        for (index = 0; index < nums.length - 1; ) {
            if (nums[index] == nums[index + 1]) {
                index += 2;
            } else {
                return nums[index];
            }
        }
        return nums[index];
    }
}
