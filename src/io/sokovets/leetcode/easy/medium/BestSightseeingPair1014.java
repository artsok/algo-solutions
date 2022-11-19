package io.sokovets.leetcode.easy.medium;

/**
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 *
 *
 * Example 1:
 *
 * Input: values = [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * Example 2:
 *
 * Input: values = [1,2]
 * Output: 2
 */
public class BestSightseeingPair1014 {


    public int maxScoreSightseeingPair(int[] values) {

        /*
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

              int answer = (values[i] + i) + (values[j] - j);
              result = Math.max(result, answer);

            }
        }
        */

        int result = 0;
        int size = values.length;
        int x = values[0]; //Первое значение максимума

        for (int j = 1; j < size; j++) {
            int y = (values[j] - j); //Никак не меняется

            // for (int i = 0; i < j; i++) {
            //Max = x + y, y < 0 (value - j), x > 0, (value + j)
            //x = (values[i] + i)
            //x = Math.max(x, values[i] + i));
            //}

            result = Math.max(result, x + y);
            x = Math.max(x, values[j] + j);
        }
        return result;
    }
}

