package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;


/**
 * Given an integer array nums, return the most frequent even element.
 *
 * If there is a tie, return the smallest one. If there is no such element, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,2,4,4,1]
 * Output: 2
 * Explanation:
 * The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
 * We return the smallest one, which is 2.
 * Example 2:
 *
 * Input: nums = [4,4,4,9,2,4]
 * Output: 4
 * Explanation: 4 is the even element appears the most.
 * Example 3:
 *
 * Input: nums = [29,47,21,41,13,37,25,7]
 * Output: -1
 * Explanation: There is no even element.
 */
public class MostFrequentEvenElement2404 {

    public int mostFrequentEven(int[] nums) {
        /**
         1. group only even num to map and count it. during that save max count
         2. iterate through all and get minimum

         TimeComplexity = O(N)
         SpaceComplexity = O(N)
         **/

        int maxFreq = 0;
        int element = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.merge(num, 1, Integer::sum);
                maxFreq = Math.max(maxFreq, map.get(num));
            }
        }


        //If there is no such element, return -1.
        if (map.size() == 0) {
            return -1;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                element = Math.min(element, entry.getKey());
            }
        }

        return element;
    }



}


/**
 *
 * LeetCode
 *
 * int[] arr = new int[100001];
 *         int ans = 1;
 *         for(int i : nums){
 *             if(i % 2 == 0){
 *                 arr[i]++;
 *                 if ( (arr[ans] < arr[i]) || (arr[ans] == arr[i] && ans > i) ){
 *                     ans = i;
 *                 }
 *             }
 *         }
 *         return ans == 1 ? -1 : ans;
 */