package io.sokovets.leetcode.easy.easy;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * <p>
 * Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 * <p>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 */
public class MinCostClimbingStairs746 {
    //Ты знаешь стоимость шага, чтобы вступить на этаж/лестницу
    //Зашел на лестницу и ты можешь забраться либо на 1 шаг вперед, либо на два шага вперед
    //Верни минимальную стоимость поднятия
    //Мне нужно считать до размера выше чем кол-во лестниц. Т.е размер массива + 1

    public static void main(String[] args) {
        //int[] cost = new int[]{10, 15, 20};
        //int[] cost = new int[]{1, 2, 5, 1, 8};
        //int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1};
        int[] cost = new int[] {1,2,3,4,5};
        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(cost));
    }


    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[dp.length -1 ], dp[dp.length - 2]);
    }


}
