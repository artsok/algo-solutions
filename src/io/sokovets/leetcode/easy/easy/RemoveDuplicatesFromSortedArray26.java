package io.sokovets.leetcode.easy.easy;


/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 */
public class RemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2};
        System.out.println(new RemoveDuplicatesFromSortedArray26().removeDuplicates(a));
    }


    public int removeDuplicates(int[] nums) {
        int duplicates = 0;

        int lastIndex = 1;
        int prevNumber = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prevNumber) {
                duplicates++;
                continue;
            }
            nums[lastIndex] = nums[i];
            prevNumber = nums[i];
            lastIndex++;
        }

        return nums.length - duplicates;
    }
}
