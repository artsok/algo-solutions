package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2006. Count Number of Pairs With Absolute Difference K
 * Easy
 * <p>
 * 765
 * <p>
 * 17
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
 * <p>
 * The value of |x| is defined as:
 * <p>
 * x if x >= 0.
 * -x if x < 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,1], k = 1
 * Output: 4
 * Explanation: The pairs with an absolute difference of 1 are:
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * Example 2:
 * <p>
 * Input: nums = [1,3], k = 3
 * Output: 0
 * Explanation: There are no pairs with an absolute difference of 3.
 * Example 3:
 * <p>
 * Input: nums = [3,2,1,5,4], k = 2
 * Output: 3
 * Explanation: The pairs with an absolute difference of 2 are:
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 */
public class CountNumberofPairsWithAbsoluteDifferenceK2006 {


    public static void main(String[] args) {
        System.out.println(new CountNumberofPairsWithAbsoluteDifferenceK2006().countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }


    //TimeComplexity - O(N)
    //SpaceComplexity - O(1)
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        //Map {1 - 2; 2 - 2}; k = 1

        int answer = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k >= entry.getKey()) {
                continue;
            }
            int findNumber = entry.getKey() - k;
            if (map.containsKey(findNumber)) {
                answer += entry.getValue() * map.get(findNumber);
            }
        }
        return answer;
    }


    //TimeComplexity = O(N^2)
    //SpaceComplexity = O(1)
    public int countKDifferenceO2(int[] nums, int k) {
        int countPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] - nums[i] == k) {
                    countPairs++;
                } else {
                    if (nums[i] - nums[j] == k) {
                        countPairs++;
                    }
                }
            }
        }

        return countPairs;
    }
}
