package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber202 {

    Map<Integer, Integer> cache = new HashMap<>();
    Set<Integer> mem = new HashSet<>();


    public static void main(String[] args) {
        System.out.println(new HappyNumber202().isHappy1(12));
        //System.out.println(new HappyNumber202().isHappy(2));
        //System.out.println(new HappyNumber202().isHappy(5));
        //System.out.println(new HappyNumber202().isHappy(1111111)); //Output: false, Expected: true
    }

    public boolean isHappy(int n) {

        for (int i = 0; i < 10; i++) {
            cache.put(i, (int) Math.pow(i, 2));
        }


        while (true) {
            int answer = 0;
            char[] digits = String.valueOf(n).toCharArray();
            for (int i = 0; i < digits.length; i++) {
                answer += cache.get(Integer.valueOf(digits[i] - '0'));
                //Преобразование в int из char, нужно просто отнять символ '0'
                //answer += (int) Math.pow(Integer.valueOf(digits[i] - '0'), 2); //Обратить внимание, на то что Math.pow возвращает double.
            }

            if (answer == 1) {
                return true;
            }

            if (mem.contains(answer)) {
                return false;
            } else {
                mem.add(answer);
            }


            n = answer;
        }
    }

    public boolean isHappy1(int n) {
        HashSet<Integer> hs = new HashSet<>();

        while (true) {
            int sum = 0;

            while (n != 0) {
                sum += Math.pow(n % 10, 2); //n % 10 = 2
                n = n / 10;                 //n = n / 10
            }

            if (sum == 1) {
                return true;
            } else {
                //if your number is 2, after 4-5 operation again the sum will be 2.
                //if we encounter same number again, we will check that number present in  set or not.
                //if yes, to avoid infinite while loop,return false here.
                n = sum;
                if (hs.contains(n)) {
                    return false;
                } else {
                    hs.add(n);
                }
            }
        }
    }

}
