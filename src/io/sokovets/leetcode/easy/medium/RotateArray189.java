package io.sokovets.leetcode.easy.medium;
/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */


public class RotateArray189 {

    public static void main(String[] args) {

    }


    public void rotate(int[] nums, int k) {
        //TimeComplexity = O(N)
        //SpaceComlexity = O(N+M), M = nums.length+k

        k = k%nums.length; //if k > nums.length

        int size = (nums.length - k) + (nums.length);

        int[] arr = new int[size];

        int index = 0;
        int numsIndex = 0;

        while(index < size) {
            if (numsIndex == nums.length) {
                numsIndex = 0;
            }
            arr[index] = nums[numsIndex];
            numsIndex++;
            index++;
        }

        //System.out.println(Arrays.toString(arr));
        //index: 0 1 2 3 4 5 6 7 8 9 10
        //values:{1,2,3,4,5,6,7,1,2,3,4}

        int startPosition = nums.length - k;
        int endPosition = startPosition + nums.length;

        index = 0;

        while (startPosition < endPosition) {
            nums[index] = arr[startPosition];
            index++;
            startPosition++;
        }

//         for (;startPosition < endPosition; index++) {
//             //System.out.println(startPosition);

//             nums[index] = arr[startPosition];
//             startPosition++;
//         }
    }



    public void rotateBrutForce(int[] nums, int k) {
        // speed up the rotation
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
