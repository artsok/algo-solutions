package io.sokovets.agoda;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().maxProfit(new int[]{1,2,3,4,5}));

    }


    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][];

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                dp[i][j] = Math.max(dp[i-1][j-1], prices[j]);
            }
        }

        return dp[prices.length-1][prices.length-1];
    }
    //Что ищем максимальный профит dp[N-1][M-1]
    //Базовый случай? мне кажеться
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int[][] dp = new int[prices.length][prices.length];

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] - prices[i] < 0) {
//                    continue;
//                }
                dp[i][j] = prices[j] - prices[i];
            }
        }


//        for (int col = 0; col < dp.length; col++) {
//            int localProfit = 0;
//            for (int row = 0; row < dp.length; row++) {
//                if (row + col < dp.length) {
//                    localProfit += dp[row][row+col];
//                }
//            }
//            maxProfit = Math.max(localProfit, maxProfit);
//        }



        return maxProfit;
    }
}
