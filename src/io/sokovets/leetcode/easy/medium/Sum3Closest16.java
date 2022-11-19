package io.sokovets.leetcode.easy.medium;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * <p>
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */

//https://leetcode.com/problems/3sum-closest/
public class Sum3Closest16 {

    public static void main(String[] args) {
        System.out.println(new Sum3Closest16().threeSumClosest(new int[]{-1, 2, 1, 4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {

        //Сначало надо отсортировать, чтобы сделать в порядке возврастания. Получили вот такой массив -4,-1,1,2
        Arrays.sort(nums);

        int answer = 0;


        //Идем по всем элементам
        for (int i = 0; i < nums.length; i++) {

            int a = nums[i]; //Вынесли, чтобы кажлый раз не вычислять в цикле while
            //Определили наши указатели
            int l = 0;
            int r = nums.length - 1;

            //Пока l меньше чем r
            while (l < r && i < nums.length - 1) {
                int b = nums[l];
                int c = nums[r];

                int sum = a + b + c;

                /* If our csum is closer to target, update the result with our running sum. */
                //Здесь мы запишем в answer сумму, но нам в 30 строке, нужно когда сравнвиаем от суммы отнять таргет, чтобы были верные вычисления
                if (Math.abs(sum - target) < Math.abs(answer - target)) {
                    answer = sum;
                }

                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return sum;
                }

            }

        }

        return answer;
    }
}

