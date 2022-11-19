package io.sokovets.leetcode.easy.medium;

import java.util.ArrayList;
import java.util.List;

public class DailyTemperatures739 {

    public static void main(String[] args) {
        int [] temperatures = new int[] {73,74,75,71,69,72,76,73};
        System.out.println(new DailyTemperatures739().dailyTemperatures(temperatures));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        //[73,74,75,71,69,72,76,73]
        //                       ^
        //                       ^

        int[] result = new int[temperatures.length];
        int size = temperatures.length;

        for (int l = 0; l < size; l++) {
            int days = 1;

            for (int r = l + 1; r < size; r++) {
                if (temperatures[r] > temperatures[l]) {
                    result[l] = days;
                    break;
                }
                days++;
            }
        }

        return result;
    }
}
