package io.sokovets.leetcode.easy.easy;

import java.util.Arrays;

public class RemoveElement27 {

    public static void main(String[] args) {

//        int[] i = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        System.out.println(new RemoveElement27().removeElement(i, 2));

//        int[] i2 = new int[]{1}; //Случай когда должны сами себя заменить
//        System.out.println(new RemoveElement27().removeElement(i2, 1));

//        int[] i3 = new int[]{4, 5}; //Случай когда должны сами себя заменить
//        System.out.println(new RemoveElement27().removeElement(i3, 5));
//
//        int[] i4 = new int[]{2, 2, 2}; //Случай когда должны сами себя заменить
//        System.out.println(new RemoveElement27().removeElement(i4, 2));


        //LeetCode solution
        int[] i5 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new RemoveElement27().removeElementRightSolution(i5, 2));

    }


    //Заводим два указателя
    //Итерируемся по l и с r меняем местами. Когда l совпадает с val то, приравниваем l = [r-1] значение. уменьшаем r--; l остается на том же месте.
    // Смотрим потом опять равняется ли l нашему значению по val
    public int removeElementRightSolution(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public int removeElement(int[] nums, int val) {

        int l = 0;
        int r = nums.length - 1;
        int count = 0;

        //222
        while (l <= r) {
            if (nums[l] == val) {

                if (nums[r] == Integer.MIN_VALUE) {
                    nums[l] = Integer.MIN_VALUE;
                    count++;
                }

                if (nums[r] != val) {
                    nums[l] = nums[r];
                    nums[r] = Integer.MIN_VALUE;
                    count++;
                    l++;
                    r--;
                }

                if (nums[l] == val && nums[r] == val) {
                    nums[r] = Integer.MIN_VALUE;
                    r--;
                    count++;
                }

            } else {
                l++;
            }
        }

        return nums.length - count;
    }

    public int removeElementNotWorkForLeetCode(int[] nums, int val) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else if (nums[i] > val) {
                break;
            }
        }
        return nums.length - count;
    }

}
