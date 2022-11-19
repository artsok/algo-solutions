package io.sokovets.leetcode.easy.medium;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
 * <p>
 * Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,6,1,2,5], k = 2
 * Output: 2
 * Explanation:
 * We can partition nums into the two subsequences [3,1,2] and [6,5].
 * The difference between the maximum and minimum value in the first subsequence is 3 - 1 = 2.
 * The difference between the maximum and minimum value in the second subsequence is 6 - 5 = 1.
 * Since two subsequences were created, we return 2. It can be shown that 2 is the minimum number of subsequences needed.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 1
 * Output: 2
 * Explanation:
 * We can partition nums into the two subsequences [1,2] and [3].
 * The difference between the maximum and minimum value in the first subsequence is 2 - 1 = 1.
 * The difference between the maximum and minimum value in the second subsequence is 3 - 3 = 0.
 * Since two subsequences were created, we return 2. Note that another optimal solution is to partition nums into the two subsequences [1] and [2,3].
 * Example 3:
 * <p>
 * Input: nums = [2,2,4,5], k = 0
 * Output: 3
 * Explanation:
 * We can partition nums into the three subsequences [2,2], [4], and [5].
 * The difference between the maximum and minimum value in the first subsequences is 2 - 2 = 0.
 * The difference between the maximum and minimum value in the second subsequences is 4 - 4 = 0.
 * The difference between the maximum and minimum value in the third subsequences is 5 - 5 = 0.
 * Since three subsequences were created, we return 3. It can be shown that 3 is the minimum number of subsequences needed.
 */
public class PartitionArraySuchThatMaximumDifferenceIsK2294 {

    public static void main(String[] args) {

    }

     /*
        TimeComplexity = O(LogN*N)
        SpaceComplexity = O(1)
    */

    public int partitionArray(int[] nums, int k) {
        //Требуется создать subsequence (подпоследовательности) у которых разница максимального и минимального значения в этой подпоследовательности будет равна k
        Arrays.sort(nums);
        //[1,2,3,5,10]
        //             ^
        //             ^
        int l = 0;
        int r = 0;

        int counter = 0;

        while (r < nums.length) { //Пока один из указателей не достигнет конца

            //Смотрим чтоб указатель l не выволился за границы и проверяем чтобы разность минимального и максимального значения была больше или равна k
            while (l < nums.length && nums[l] - nums[r] <= k) {

                //если так то увеличиваем l
                l++;
            }

            //Если нет то приравниваем r = l
            r = l;
            counter++; //увеличиваем счетчик
        }
        return counter;
    }

}
