//package io.sokovets.hackerrank;
//
//public class MaximumIndex {
//
//    public static int maxIndex(int steps, int badIndex) {
//        // Write your code here
//        //i -> i + j
//        //i -> i
//
//        //i[0] = 0;
//        //j[0] -> 1; //incriment + 1
//        //avoided index
//
//        //dp[0] - based
//        //dp[i] - maximum index
//
//        int[] dp = new int[steps + 1];
//        dp[0] = 0;
//
//        //Arrays.fill(dp, dp.length);
//
//        for (int i = 1; i < steps; i++) {
//
//            for (int j = 1; j <= 2; j++) {
//                dp[i] +=  Math.max(dp[i], dp[i+j]);
//            }
//        }
//
//        return dp[dp.length-1];
//    }
//
//    public static int maxIndex(int steps, int badIndex) {
//        // Write your code here
//        //i -> i + j
//        //i -> i
//
//        //i[0] = 0;
//        //j[0] -> 1; //incriment + 1
//        //avoided index
//
//        //dp[0] - based
//        //dp[i] - maximum index
//
//        int[] dp = new int[steps + 1];
//        dp[0] = 0;
//
//        //Arrays.fill(dp, dp.length);
//
//        for (int i = 1; i < steps; i++) {
//
//            for (int j = 1; j <= 2; j++) {
//                dp[i] +=  Math.max(dp[i], dp[i+j]);
//            }
//        }
//
//        return dp[dp.length-1];
//    }
//}
