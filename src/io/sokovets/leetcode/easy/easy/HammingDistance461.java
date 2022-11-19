package io.sokovets.leetcode.easy.easy;

import java.util.Arrays;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, return the Hamming distance between them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * Example 2:
 * <p>
 * Input: x = 3, y = 1
 * Output: 1
 */
public class HammingDistance461 {

    //As a result, in order to measure the hamming distance between x and y, we can first do x XOR y operation, then we simply count the number of bit 1 in the result of XOR operation.
    public static void main(String[] args) {

    }

    public int hammingDistanceLT(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    //Первое решение - 21.07.22
    public int hammingDistance(int x, int y) {
        //Algorithm
        //1.Represent x and y in binary represantation
        //2.Count a diff. Start from right to left.

        //10101010101010000
        //10101

        StringBuilder temp = new StringBuilder();

        //Representing of X in binary format
        while (x != 0) {
            temp.append(x % 2);
            x = x / 2;
        }

        String strX = temp.reverse().toString();

        temp.delete(0, strX.length());

        //Representing of Y in binary format
        while (y != 0) {
            temp.append(y % 2);
            y = y / 2;
        }

        String strY = temp.reverse().toString();

        int maxLength = Math.max(strX.length(), strY.length());
        int minLength = Math.min(strX.length(), strY.length());

        char[] charY = null;
        char[] charX = null;

        if (strX.length() > strY.length()) {
            charY = new char[maxLength];
            Arrays.fill(charY, '0');
            char[] originalY = strY.toCharArray();

            for (int i = maxLength - 1; i >= 0; i--) {
                if (minLength <= 0) {
                    continue;
                }

                charY[i] = originalY[minLength - 1];
                minLength--;
            }

            charX = strX.toCharArray();


        } else {
            charX = new char[maxLength];
            Arrays.fill(charX, '0');

            char[] originalX = strX.toCharArray();

            for (int i = maxLength - 1; i >= 0; i--) {
                if (minLength <= 0) {
                    continue;
                }
                charX[i] = originalX[minLength - 1];
                minLength--;
            }

            charY = strY.toCharArray();
        }

        int count = 0;

        for (int i = 0; i < maxLength; i++) {
            if (charX[i] != charY[i]) {
                count++;
            }
        }

        return count;

    }
}
