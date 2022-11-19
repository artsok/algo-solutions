package io.sokovets.leetcode.easy.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class MaximumSubarray53 {

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    public int maxSubArray(int[] nums) {
        //1. Что мы считаем? Какие значения вычисляем: Вычисляем сумму подмассивов. Берем ту, которая больше
        //2. Как будем пересчитывать? F(N) =

        /*
        dp[0] = -2
        dp[1] = Math.max(i, [(i-1)] + [i]); = 1
        dp[2] = Math.max(i, [(i-1)] + [i]) = -2
        dp[3] = Math.max(i, [(i-1)] + [i]) =  4
        dp[5] = Math.max(i, [(i-1)] + [i]) = 3
        dp[6] = Math.max(i, [(i-1)] + [i]) = 5
        dp[7] = Math.max(i, [(i-1)] + [i]) = 6
        dp[8] = Math.max(i, [(i-1)] + [i]) = 1
        dp[9] = Math.max(i, [(i-1)] + [i]) = 4


        dp[0] = 5;
        dp[1] = 9; //res = 9
        dp[2] = 8; //res=9
        dp[3] = 15; //res=15
        dp[4] = 23;
        */

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(dp[i], result);
        }

        return result;
    }
}
