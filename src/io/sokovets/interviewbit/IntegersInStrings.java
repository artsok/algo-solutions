package io.sokovets.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string A, consisting of comma-separated positive integers.
 * Extract the given integers from the string and return an integer array consisting of the integers present in the string.
 * <p>
 * Note: All given integers will fit in a 32-bit signed integer.
 * <p>
 * Input 1:
 * A = "1,2,3"
 * Input 2:
 * <p>
 * A = "1,99,3"
 * <p>
 * <p>
 * Output 1:
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 99, 3]
 */
public class IntegersInStrings {

    public static void main(String[] args) {
        String a = "1,99,3";
        System.out.println(Arrays.toString(new IntegersInStrings().solve(a)));

    }


    /**
     * public class Solution {
     *     public int[] solve(String A) {
     *         ArrayList<Integer> arr = new ArrayList<Integer>();
     *         int num=0;
     *         for(int i=0; i<A.length(); i++) {
     *             if (A.charAt(i)==',') {
     *                 arr.add(num);
     *                 num = 0;
     *             } else {
     *                 num = num*10 + (A.charAt(i) - '0');
     *             }
     *         }
     *         if (num>0) arr.add(num);
     *         int[] ret = new int[arr.size()];
     *         for(int i=0; i<arr.size(); i++) ret[i] = arr.get(i);
     *
     *         return ret;
     *     }
     * }
     */

    public int[] solve(String A) {

        String[] digits = A.split(",");

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < digits.length; i++) {
            result.add(Integer.parseInt(digits[i]));
        }

        int[] arr = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}
