package io.sokovets.leetcode.easy.easy;


import java.util.HashSet;
import java.util.Set;

/**
 * You are given a 0-indexed integer array nums whose length is a power of 2.
 * <p>
 * Apply the following algorithm on nums:
 * <p>
 * Let n be the length of nums. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n / 2.
 * For every even index i where 0 <= i < n / 2, assign the value of newNums[i] as min(nums[2 * i], nums[2 * i + 1]).
 * For every odd index i where 0 <= i < n / 2, assign the value of newNums[i] as max(nums[2 * i], nums[2 * i + 1]).
 * Replace the array nums with newNums.
 * Repeat the entire process starting from step 1.
 * Return the last number that remains in nums after applying the algorithm.
 * <p>
 * <p>
 * Input: nums = [1,3,5,2,4,8,2,2]
 * Output: 1
 * Explanation: The following arrays are the results of applying the algorithm repeatedly.
 * First: nums = [1,5,4,2]
 * Second: nums = [1,4]
 * Third: nums = [1]
 * 1 is the last remaining number, so we return 1.
 * Example 2:
 * <p>
 * Input: nums = [3]
 * Output: 3
 * Explanation: 3 is already the last remaining number, so we return 3.
 */
public class MinMaxGame2293 {

    public static void main(String[] args) {
        int[] temp = new int[]{70, 38, 21, 22};
        //int[] temp = new int[]{1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(new MinMaxGame2293().minMaxGame(temp));
    }


    public int minMaxGame(int[] nums) {

        /**
         My algorithm
         1. Greate a 2D-array
         2. Copy nums to zero row
         3. Fill each row. Start from 1 row.
         Calculate values using formula (Math.max(temp[i-1][2*j], temp[i-1][2*j+1])) for max and for min (Math.min(temp[i-1][2*j], temp[i-1][2*j+1]))
         3. Outer inner  decrease size in 2 times
         4. return answer from array[size/2][0]
         **/


        /**
         1,3,5,2,4,8,2,2
         1,5,4,2
         1,4
         1 - искать результат в последней строке. она получается как nums/2
         **/

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int[][] temp = new int[nums.length / 2 + 1][nums.length];
        System.arraycopy(nums, 0, temp[0], 0, nums.length);

        int size = nums.length / 2;

        for (int i = 1; i <= nums.length / 2; i++) {
            System.out.println("i = " + i);

            for (int j = 0; j < size; j++) {

                if (j % 2 == 1) {
                    temp[i][j] = Math.max(temp[i - 1][2 * j], temp[i - 1][2 * j + 1]);
                    //System.out.println("max");
                    //System.out.println(temp[i-1][2*j]);
                    //System.out.println(temp[i-1][2*j+1]);
                    //  System.out.println(temp[i][j]);
                } else {
                    temp[i][j] = Math.min(temp[i - 1][2 * j], temp[i - 1][2 * j + 1]);
                    // System.out.println("min");
                    //System.out.println(temp[i-1][2*j]);
                    //System.out.println(temp[i-1][2*j+1]);
                    // System.out.println(temp[i][j]);

                }

            }

            size /= 2;
            System.out.println(size);
        }

        return temp[nums.length / 2][0];
    }


    public int minMaxGameRecursion(int[] nums) {
        return minMaxGameR(nums, 0, nums.length - 1, true);
    }

    private int minMaxGameR(int[] nums, int L, int R, boolean minOrMax) {
        if (L == R) {
            return nums[L];
        }
        int mid = (L + R) / 2;
        if (minOrMax) {
            return Math.min(minMaxGameR(nums, L, mid, true), minMaxGameR(nums, mid + 1, R, false));
        } else {
            return Math.max(minMaxGameR(nums, L, mid, true), minMaxGameR(nums, mid + 1, R, false));
        }
    }

    public int minMaxGame02_08_22(int[] nums) {

        //TimeComplexity = O(LogN)
        //SpaceComlexity = O(1)

        /**
         1. Use while until nums.length != 0;
         2. Intoduce k, which means the current index of operation Max,Min
         3. Use inner for loop with step 2;
         4. Find result in new nums
         **/


        /**
         TestCases:
         [1,3,5,2,4,8,2,2] n = 4
         newNums: [1, 5, 4, 2] n = 2
         newNums: [1, 4] n = 1
         newNums: [1] n = 0

         TestCases2:
         [1,2] n = 1
         newNums: [1] n = 0

         TestCases3 (InValid):
         [1,2,3] n = 1
         newNums: [1] n = 0

         TestCases4:
         [1] n = 1
         **/

        if (nums.length == 1) {
            return nums[0];
        }

        int size = nums.length;

        int k = 0;
        while (size != 0) {

            for (int i = 0; i < size/2; i++) {
                if (i%2 == 0) {
                    nums[k] = Math.min(nums[2*i], nums[2*i+1]);
                } else {
                    nums[k] = Math.max(nums[2*i], nums[2*i+1]);
                }
                k++;
            }

            k = 0;
            size /= 2;
        }

        return nums[0];
    }
}
