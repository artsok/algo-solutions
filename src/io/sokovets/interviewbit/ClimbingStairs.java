package io.sokovets.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * <p>
 * <p>
 * <p>
 * Given an integer array A of length N. Where Ai is the cost of stepping on the ith stair.
 * From ith stair, you can go to i+1th or i+2th numbered stair.
 * Initially, you are at 1st stair find the minimum cost to reach Nth stair.
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= N <= 105
 * 1 <= Ai <= 104
 * <p>
 * <p>
 * Input Format
 * The first and only argument is an integer array A.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 1, 3]
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 5
 * Output 2:
 * <p>
 * 7
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * 1 -> 3 -> 4
 * Explanation 2:
 * <p>
 * 1 -> 2 -> 4
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        //int[] A = new int[]{1, 2, 1, 3};
        int[] A = new int[]{4, 1, 2, 3, 4};

        System.out.println(new ClimbingStairs().solve(A));
    }

    //Here,A[1] should be A[0] + A[1],
    // as he is currently on step1, so going to step 2 he needs to pay A[1] more, please feel free to char for further discussion.
    public int solve(int[] A) {
        int size = A.length;
        int[] dp = new int[size];

        dp[0] = A[0];
        dp[1] = A[1] + A[0];
        for (int i = 2; i < size; i++) {
            dp[i] = A[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return dp[size - 1];
    }

//    public int solve(ArrayList<Integer> A) {
//
//        int[] dp = new int[A.size() + 1 ];
//        dp[0] = A.get(0);
//        dp[1] = A.get(1);
//
//        for (int i = 2; i < dp.length - 1; i++) {
//            dp[i] += A.get(i) + Math.min(dp[i - 1], dp[i - 2]);
//        }
//        return dp[A.size() -1 ];
//    }
}
