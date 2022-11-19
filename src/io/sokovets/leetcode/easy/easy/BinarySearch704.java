package io.sokovets.leetcode.easy.easy;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
public class BinarySearch704 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        //[1],1
        //[1,2] //1

        while (l < r) {
            int mid = l + (r - l)/2;
            //System.out.println("l=" + l + ", mid=" + mid + ", r=" + r);

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (nums[r] == target) {
            return r;
        }
        return -1;
    }


    /**
     TimeComplexity = O(LogN)
     SpaceComplexity - O(1)
     **/
    public int searchOriginalPattern(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l)/2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     [1], target = 1
     [1,5], target = 5
     [1,5], target = 1
     [1,5], target = -1


     **/
}
