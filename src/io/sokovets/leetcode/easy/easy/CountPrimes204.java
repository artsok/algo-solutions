package io.sokovets.leetcode.easy.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: 0
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: 0
 */

public class CountPrimes204 {


    public int countPrimesTLA(int n) {

        int sqrt = (int) Math.sqrt(121);

        /*A prime number is a whole number greater than 1 whose only factors are 1 and itself. A factor is a whole number that can be divided evenly into another number.

        Простое число — это целое число больше 1, единственными делителями которого являются 1 и само себя. Множитель – это целое число, которое можно без остатка разделить на другое число. */

        //There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

        if (n <= 2) {
            return 0;
        }

        List<Integer> primesNumber = new ArrayList<>();
        primesNumber.add(2);
        // primesNumber.add(3);
        // primesNumber.add(5);
        //primesNumber.add(7);

        int answer = 1;

        boolean skip = false;

        //O(n)
        for (int i = 3; i < n; i++) {

            // System.out.println("-------------- " + i);

            ListIterator<Integer> iterator = primesNumber.listIterator();

            while (iterator.hasNext()) {

                Integer prime = iterator.next();
                if (i % prime == 0) {
                    skip = true;
                    break;
                }
            }

            if (skip) {
                skip = false;
                continue;
            }

            if (!iterator.hasNext()) {
                iterator.add(i);
            }

            String.valueOf(4).length();

            System.out.println(primesNumber);
        }

        return primesNumber.size();

    }
}
