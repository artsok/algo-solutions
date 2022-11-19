package io.sokovets.leetcode.easy.easy;


/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 */
public class PowerOfThree326 {

    //TimeComplexity - O(LogN)
    //SpaceComplexity - O(1)

    public static void main(String[] args) {
        System.out.println(new PowerOfThree326().isPowerOfThree(27));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        double epsilon = 0.00001;
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
}

