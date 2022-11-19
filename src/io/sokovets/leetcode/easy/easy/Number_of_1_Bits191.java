package io.sokovets.leetcode.easy.easy;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 */
public class Number_of_1_Bits191 {


    public static void main(String[] args) {

        /**
        Проверка для себя. двигаем по битово и проверяем какое получилось число.
        byte a = 0b100;
        byte b = 0b001;

        for (int i = 0; i < 3; i++) {
            byte c = (byte) (a & b);
            b = (byte) (b << 1);
        }
        **/


        int n = 0b00000000000000000000000000001011;
        System.out.println(new Number_of_1_Bits191().hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int mask = 1;
        int counts = 0;

        //1011 - наше число это N
        //1 = 1, 2 = 10, 4 = 100

        for (int i = 0; i < 32; i++) {
            //Так как двигаем по битово, и в третьем бите к примеру у нас 1-ка (число 100),
            // а сравниваем с 001, то сначала сравнение будет 0, далее двигаем маску и получилось число 2(0b10) здесь тоже ноль,
            // опять двигаем и получается 100 (изначальное число) и 0_b100 (это маска) и здесь получается биты равны, но число получается итоговое 100, 4-ка
            if ((mask & n) != 0) {
                counts++;
            }
            mask = mask << 1;
        }

        return counts;
    }

    public int hammingWeightWithFormula(int n) {
        int count;
        for (count = 0; n != 0; count++) {
            n &= n - 1;
        }
        return count;
    }

}
