package io.sokovets.leetcode.easy.easy;

import java.math.BigInteger;

public class ReverseBits190 {

    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        int n1 = 0b00000010100101000001111010011100;
        int test = 0b000000101;
        int n3 = 0b11111111111111111111111111111101;
        System.out.println(new ReverseBits190().reverseBits(n3));
    }

    //10111111111111111111111111111111
    //10111111111111111111111111111111


    public int reverseBits(int n) {

        //Преобразовали в строку
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));

        while (sb.length() > 32) {
            sb.insert(0, '0'); //Добавляет на 0 индекс значение 0 и так делает пока длина sb не будет равна 32.
        }


        return new BigInteger(sb.reverse().toString(), 2).intValue();


        //100 = 2^1+2^0
        //int result = 0;

            //Возведение в степень двойуи
//        int count = 0;
//        for (int i = chars.length - 1; i >= 0; i--) {
//            if (chars[i] == '1') {
//                result += (int) Math.pow(2, count);
//            }
//            count++;
//        }

        //new BigInteger(bin.reverse().toString(), 2).intValue();

    }
}

    //Создали другую строку. Заполнили первые битики 0. Взяли разницу от того числа которое пришло и в длинну 32 символа
//    StringBuilder int32 = new StringBuilder();
//        for (int i = 0; i < 32 - sb.length(); i++) {
//        int32.append('0');
//        }
//
//        //Добавили число которое пришло к нашему числу в 32
//        int index = 0;
//        for (int i = 32 - sb.length(); i < 32; i++) {
//        int32.insert(i, sb.charAt(index));
//        index++;
//        }
//
//
//        char[] chars = int32.reverse().toString().toCharArray();
