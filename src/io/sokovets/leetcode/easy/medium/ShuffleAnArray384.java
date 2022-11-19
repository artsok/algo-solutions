package io.sokovets.leetcode.easy.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * All permutations of the array should be equally likely as a result of the shuffling.
 * <p>
 * Implement the Solution class:
 * <p>
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must be equally likely to be returned.
 * // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 *
 * 1 <= nums.length <= 50
 *
 * -106 <= nums[i] <= 106
 *
 * All the elements of nums are unique.
 *
 * At most 104 calls in total will be made to reset and shuffle.
 *
 * https://neerc.ifmo.ru/wiki/index.php?title=%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%B3%D0%B5%D0%BD%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D0%B8_%D1%81%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%BE%D0%B9_%D0%BF%D0%B5%D1%80%D0%B5%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B8,_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%A4%D0%B8%D1%88%D0%B5%D1%80%D0%B0-%D0%99%D0%B5%D1%82%D1%81%D0%B0
 */
public class ShuffleAnArray384 {

    private Random random;
    private int[] nums;

    private int[] copyNums;
    private int size;

    ShuffleAnArray384(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        this.copyNums = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        this.copyNums = Arrays.copyOf(nums, nums.length);
        return copyNums;
    }

    public int[] shuffle() {
        return randomPermutation(copyNums);
    }

    private int[] randomPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            Random random = new Random();
            int index = random.nextInt((size - 1) + 1);
            swap(i, index, nums);
        }
        return nums;
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        ShuffleAnArray384 test = new ShuffleAnArray384(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(test.shuffle()));
    }

}
