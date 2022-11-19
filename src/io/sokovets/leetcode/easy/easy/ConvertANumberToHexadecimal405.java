package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.
 * <p>
 * All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.
 * <p>
 * Note: You are not allowed to use any built-in library method to directly solve this problem.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 26
 * Output: "1a"
 * Example 2:
 * <p>
 * Input: num = -1
 * Output: "ffffffff"
 */

//Дополнительно как перевести число в отрицательный формат
//https://www.cs.cornell.edu/~tomf/notes/cps104/twoscomp.html

/**
 * Two's complement is the way every computer I know of chooses to represent integers. To get the two's complement negative notation of an integer, you write out the number in binary. You then invert the digits, and add one to the result.
 * <p>
 * Suppose we're working with 8 bit quantities (for simplicity's sake) and suppose we want to find how -28 would be expressed in two's complement notation. First we write out 28 in binary form.
 * <p>
 * 00011100
 * Then we invert the digits. 0 becomes 1, 1 becomes 0.
 * <p>
 * 11100011
 * Then we add 1.
 * <p>
 * 11100100
 * That is how one would write -28 in 8 bit binary.
 */
public class ConvertANumberToHexadecimal405 {

    public static void main(String[] args) {
        //System.out.println(new ConvertANumberToHexadecimal405().toHex(-1));
        //System.out.println(new ConvertANumberToHexadecimal405().toHex(0));


            //System.out.println(new ConvertANumberToHexadecimal405().toHex(-2));
        System.out.println(new ConvertANumberToHexadecimal405().toHex(-1));
    }

    //ffffffff

    public String toHex(int num) {
//        if (num < 0) {
//            num = (~num+1);
//            System.out.println(num); //(~-4+1)
//            //~0x1+1 << 0xFF
//        }

        //int a = 0b1111_1111_1111_1111_1111_1111_1111_1111;
//        int a = 0b0000_0000_0000_0000_0000_0000_0000_0001;
//        System.out.println(~a);

        //25 = 16^1 + 9*16^0
        //444 = 16^2 + 11 * 16^1 + 12 * 16^0
        //444 = 256 + 176 + 12

        long numTemp;

        if (num < 0) {
            numTemp = (long) (Math.pow(2, 43) + num);
        } else {
            numTemp = num;
        }

        //Заполняем мапу десятичными значениями и как они соотносятся к HEX
        Map<Long, Character> map = new HashMap<>();
        for (long i = 0; i <= 15; i++) {
            if (i >= 10) {
                map.put(i, (char) (i + 'W'));
            } else {
                map.put(i, (char) ('0' + i));
            }
        }



        //0 - 0
        //..
        //10 - A
        //11 - B
        //12 - C
        //15 - F

        //26%16=10->Map.read->a
        //Далее 26/16 = 1
        //1%16=1->Map.read будет 1
        //в SB запишем a1
        //reverse = 1a
        //0b11111111111111111111111111111011

        StringBuilder sb = new StringBuilder("");

        do {
            sb.append(map.get(numTemp % 16));
            numTemp /= 16;
        }
        while (numTemp != 0);


        return sb.reverse().toString();
    }
}
