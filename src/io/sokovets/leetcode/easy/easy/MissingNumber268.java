package io.sokovets.leetcode.easy.easy;

import org.w3c.dom.ls.LSOutput;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber268 {


    //int sum = size * (size + 1) / 2; - Это формула получение суммы всех чисел, которая входит в диапазон от 0 до N

    public static void main(String[] args) {
        //int sum = 3 * (3 + 1) / 2;
        //System.out.println(sum);
        int[] a = new int[]{3, 0, 1};
        System.out.println(new MissingNumber268().missingNumber(a));
    }


    public int missingNumber(int[] nums) {
        //1. nums.length
        //2. missed digit in the nums

        //Approach #1
        //1.Sort
        //2. iterate from 0 to nums.length
        //3. check if (sorted items contains in nums)
        //O(N*logN)

        //Approach #2
        //3,0,1 -> should find two (Binary Search)
        //0,1,3
        //l and r = pointers
        //[l] < [l+1], r > [r+1]
        //O(N*logN)

        //Approach #3
        //1.We know the size of range
        //2.All numbers are unic
        //3.We could make sum of size
        //4.Iterate the nums and subtract number from sum

        int result = 0;


        for (int i = 0; i < nums.length; i++) {
            result += i - nums[i];
        }

        return result + nums.length;

    }
}
