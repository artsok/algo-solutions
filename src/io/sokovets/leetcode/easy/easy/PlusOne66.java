package io.sokovets.leetcode.easy.easy;

import java.util.Arrays;

/**
 * 66. Plus One
 * Easy
 *
 * 4675
 *
 * 4296
 *
 * Add to List
 *
 * Share
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 */
public class PlusOne66 {

    public static void main(String[] args) {

    }


    //TimeComplexity = O(N)
    //SpaceComplexity = O(1)
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int[] temp = new int[size+1];
        boolean flag = true;

        for (int i = size - 1; i >= 0; i--) { //Идем с конца
            if (flag) { //если у нас флаг стоит в true, то продолжаем движение
                int sum = digits[i] + 1; //Прибавляем 1 к тек.элементу
                temp[i+1] = sum%10; //записываем во временный массив остаток от деления
                if (sum < 10) { //Если получившиеся сумма меньше, чем 10, то выставляем флаг в false.
                    flag = false;
                } else { //Больше то в true
                    flag = true;
                }
            } else { //В иных случаях прост пишем остаток
                temp[i+1] = digits[i]%10;
            }
        }

        if (flag) { //Смотрим, если последний флаг был в true, то мы добавляем еще единицу
            temp[0] = 1;
        }

        if (temp[0] == 0) { ////Если первый индекс 0, то обрезать массив temp и вернуть индексы с 1 по конец
            return Arrays.copyOfRange(temp, 1, temp.length);
        }
        return temp;
    }
}
