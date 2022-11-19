package io.sokovets.leetcode.easy.easy;

import javax.xml.transform.Source;

/**
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
 * <p>
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
 * Example 2:
 * <p>
 * Input: gain = [-4,-3,-2,-1,4,3,2]
 * Output: 0
 * Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */

public class FindTheHighestAltitude1732 {


    public static void main(String[] args) {
        int[] gain = new int[]{-5, 1, 5, 0, -7};
        System.out.println(new FindTheHighestAltitude1732().largestAltitude(gain));
    }

    //Time Complexity = O(N)
    //Space Complexity = O(1)
    public int largestAltitude(int[] gain) {
        //gain
        //net gain in altitude - чистый прирост среди точек i и i+1
        //Байкер начинает свое путешествие в точке 0 с высотой равной 0.
        //Вопрос стоит: Верните наибольшую высоту точки

        //gain[0] = gain[0] + gain[1];

        int highestAltitude = 0;
        int result = 0;

        for (int i = 0; i < gain.length; i++) {
            result = result + gain[i];

            if (result > highestAltitude) { //Такая запись быстрее чем Math.max
                highestAltitude = result;
            }
            //highestAltitude = Math.max(highestAltitude, result);
        }
        return highestAltitude;
    }

}
