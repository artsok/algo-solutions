package io.sokovets.leetcode.easy.easy;

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * Example 2:
 * <p>
 * Input: num = 0
 * Output: 0
 */
public class AddDigits258 {

    public static void main(String[] args) {
        new AddDigits258().addDigits(38);
    }


    public int addDigitsLP(int num) {
        int digitalRoot = 0;
        while (num > 0) { //Больше 0
            digitalRoot += num % 10;
            num = num / 10;

            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }
        return digitalRoot;
    }

    public int addDigits(int num) {


        int result = 0;
        while (num != 0) {

            while (num != 0) {
                result += num % 10;
                num /= 10;
            }

            if (result <= 9) {
                break;
            } else {
                num = result;
                result = 0;
            }
        }
        return result;
    }

}
