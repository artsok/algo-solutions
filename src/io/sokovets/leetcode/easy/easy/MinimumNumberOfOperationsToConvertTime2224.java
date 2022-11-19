package io.sokovets.leetcode.easy.easy;

/**
 * You are given two strings current and correct representing two 24-hour times.
 * <p>
 * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
 * <p>
 * In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.
 * <p>
 * Return the minimum number of operations needed to convert current to correct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: current = "02:30", correct = "04:35"
 * Output: 3
 * Explanation:
 * We can convert current to correct in 3 operations as follows:
 * - Add 60 minutes to current. current becomes "03:30".
 * - Add 60 minutes to current. current becomes "04:30".
 * - Add 5 minutes to current. current becomes "04:35".
 * It can be proven that it is not possible to convert current to correct in fewer than 3 operations.
 * Example 2:
 * <p>
 * Input: current = "11:00", correct = "11:01"
 * Output: 1
 * Explanation: We only have to add one minute to current, so the minimum number of operations needed is 1.
 */
public class MinimumNumberOfOperationsToConvertTime2224 {


    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfOperationsToConvertTime2224().convertTime("02:30", "04:35"));
        System.out.println(new MinimumNumberOfOperationsToConvertTime2224().convertTime("11:00", "23:06"));
        System.out.println(new MinimumNumberOfOperationsToConvertTime2224().convertTime("00:00", "23:59"));
    }

    public int convertTime(String current, String correct) {
        // In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.

        //23:59 00:00
        //00:00 23:59

        //2359 -> 0
        //2359/60=39%15=9%5=4%1

        //1. Convert to Integer
        //2. correct - current
        //3.

        //"02:30", correct = "04:35"


        //00:50
        //01:05

        int countOperations = 0;

        int currentTimeHH = Integer.parseInt(current.split(":")[0]);
        int currentTimeMM = Integer.parseInt(current.split(":")[1]);

        int correctTimeHH = Integer.parseInt(correct.split(":")[0]);
        int correctTimeMM = Integer.parseInt(correct.split(":")[1]);

        int currentMin = currentTimeHH * 60 + currentTimeMM;
        int correctMin = correctTimeHH * 60 + correctTimeMM;

        int[] times = {60, 15, 5, 1};
        int diffMin = correctMin - currentMin;

        while (diffMin != 0) {
            for (int time : times) {
                countOperations += diffMin/time;
                diffMin = diffMin%time;
            }
        }

        return countOperations;
    }

}
