package io.sokovets.leetcode.easy.easy;


/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * <p>
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 */
public class PowerOfFour342 {
    public static void main(String[] args) {
        System.out.println(new PowerOfFour342().isPowerOfFour(16));
    }


    //Hence power of four would make a zero in a bitwise AND with number (101010...10)_2(101010...10)
    //Побитовая операции И сделает 0 с числом (двоичное число 101010...10), так как нам нужны битики которые стоят нечетно (odd)
    //число 10101 = можно представить 0xaaaaaaaa
    public boolean isPowerOfFour1(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }

    //TimeComplexity - O(LogN)
    //SpaceComplexity = O(1)
    public boolean isPowerOfFour(int n) {

        if (n == 0) {
            return false;
        }

        long x = n;

        while (x % 4 == 0) {
            x = x / 4;
        }

        return x == 1;
    }
}
