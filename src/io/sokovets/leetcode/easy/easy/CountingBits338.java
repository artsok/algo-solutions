package io.sokovets.leetcode.easy.easy;

import java.util.Arrays;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
//https://javarush.ru/groups/posts/1925-pobitovihe-operacii
public class CountingBits338 {

    public static void main(String[] args) {
        //System.out.println(new CountingBits338().bitsInNumber(13));
        System.out.println(Arrays.toString(new CountingBits338().countBits(16)));
    }

    //[0,1,1,2,1,2,2,3,1,2, 2, 3,  2, 3, 3, 4, 1] - Expected
    //[0,1,1,2,1,2,2,3,1,2, 2, 3,  3, 4, 4, 5, 1] - Output
    // 0 1 2 3 4 5 6 7 8 9 10  11  12 13 14 15 16
    public int[] countBits(int n) {

        if (n == 0) {
            return new int[]{0};
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        int index = 0;
        for (int i = 2; i <= n; i++) {
            //2,4
            if (i % 2 == 0) { //Определяем что это число четное
                if (2 << index == i) { //У нас есть случаи когда 4, 8, 16, 32, 64. Определяем что это числа, которые содержат 1 бит
                    dp[i] = 1;
                    index++;
                } else {
                    dp[i] = dp[i/2];  //Мы ссылаемся на предыдущий результат (https://calculatori.ru/perevod-chisel.html).
                    // Потому-что делим и записываем в обратном направление
                }
            } else {
                dp[i] += dp[i - 1] + 1; //Для нечетных всегда берем предыдущую и увеличиваем
            }
        }

        return dp;
    }



    /**
     * Идеальное решение!!
     * class Solution {
     *     public int[] countBits(int num) {
     *         int[] res = new int[num+1];
     *         for(int i=1;i<res.length;i++){
     *             res[i]=res[i>>1]+(i&1);
     *         }
     *         return res;
     *     }
     * }
     *
     */


    public int bitsInNumber(int n) {
        int res = 0;
        while (n > 0) {
            //Сдвиги вправо
            n = n >> 1;   //35 >> 2 = 8, означает, что нам нужно 2 раза разделить 35 на 2, отбрасывая остатки
            res++;
        }
        return res;
    }
}
