package io.sokovets.leetcode.easy.easy;


/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 */
public class MergeSortedArray88 {

    public static void main(String[] args) {

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            //nums1 = nums2;
        } else if (n == 0) {
            return;
        }

        int[] nums3 = new int[m + n];

        int l1 = 0;
        int l2 = 0;

        int index = 0;

        while (index < m + n) {


            //Когда указатель l1 дошел до m
            if (l1 == m) {

                //в этом случае копируем все из nums2[l2]
                for (int i = l2; i < n; i++) {
                    nums3[index] = nums2[l2];
                    index++;
                    l2++;
                }
                continue;

                //Когда указатель l2 дошел до n
            } else if (l2 == n) {
                for (int i = l1; i < m; i++) {
                    nums3[index] = nums1[l1];
                    l1++;
                    index++;
                }
                continue;
            }

            //Рассматриваем варианты, когда число в nums1 больше чем число в nums2
            if (nums1[l1] > nums2[l2]) {
                nums3[index] = nums2[l2];
                index++;
                l2++;

            //Рассматриваем варианты, когда число в nums1 меньше чем число в nums2
            } else if (nums1[l1] < nums2[l2]) {
                nums3[index] = nums1[l1];
                l1++;
                index++;

                //Когда числа равны
            } else {
                nums3[index] = nums1[l1];
                l1++;
                index++;
            }

        }

        //Копируем из нового массива в nums1
        for (int i = 0; i < nums3.length; i++) {
            nums1[i] = nums3[i];
        }

    }
}
