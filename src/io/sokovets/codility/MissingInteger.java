package io.sokovets.codility;

import java.util.Arrays;

public class MissingInteger {

    public static int solution(final int[] A) {
        Arrays.sort(A);
        int min = 1;

        // Starting from 1 (min), compare all elements, if it does not match that would the missing number.
        for (int i : A) {
            if (i == min) {
                min++;
            }
        }

        return min;
    }
}
