package io.sokovets.hackerrank;

import java.util.*;

public class BinaryGap {

    //Вот такие числа не просчитываются (51712=110010100000000)
    public static void main(String[] args) {
        //System.out.println(new BinaryGap().solution(51712));
        System.out.println(new BinaryGap().solution(5));
    }

    public int solution(int N) {
        StringBuilder sb = new StringBuilder();

        while (N != 0) {
            sb.append(N % 2);
            N = N / 2;
        }

        String binaryFormat = sb.reverse().toString();
        char[] arrChars = binaryFormat.toCharArray();

        int countOne = 1;
        int currCountZero = 0;
        int maxCountZero = 0;


        int[] result = new int[arrChars.length];


        Deque<Integer> a = new ArrayDeque<>();

        int curIndex = 0;
        int prevIndex = 0;
        int maxLength = 0;

        //10110
        for (int i = 1; i < arrChars.length; i++) {
            if (arrChars[i] == '1') {
                curIndex = i;
                //prevIndex
                maxLength = Math.max(curIndex - prevIndex, maxLength);
            }
            prevIndex = curIndex;
        }
        return maxLength;
    }
}

/**
 * int zeroIndex = 0;
 * int oneCount = 0;
 * <p>
 * for (int i = 0; i < arrChars.length; i++) {
 * if (arrChars[i] == '1') {
 * zeroIndex++;
 * oneCount++;
 * continue;
 * }
 * result[zeroIndex] += 1;
 * }
 * <p>
 * if (oneCount == 1) {
 * return 0;
 * }
 * <p>
 * Arrays.sort(result);
 * <p>
 * return result[result.length - 1];
 */
