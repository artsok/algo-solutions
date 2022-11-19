package io.sokovets.leetcode.easy.easy;


/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 */
public class ReverseStringII541 {

    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {


        //s = "abcdefg", answer = bacdfeg

        //s = "abc", k = 4, answer = cba, case:  If there are fewer than k characters left, reverse all of them

        //s = "abcdk", k = 2, answer = bacdk case:  If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

        //s = "abcdefg", k = 2, answer = bacdfeg

        //"abcdsdsd", k = 2
        // 01234567
        // bacddssd

        char[] chrs = s.toCharArray();

        int l = 0;
        int r = chrs.length - 1;
        int size = chrs.length;

        // System.out.println("size = " + size);


        if (k == 1) {
            return s;
        }

        if (k > size) {
            swap(chrs, l, r);

        } else {

            for (int i = 0; i < size; i = i + 2*k) {

                // 0123456789

                int tempL = i;
                int tempR = i + k -1;

                if (tempR >= size) {
                    tempR = size - 1;
                }

                //System.out.println("tempL = " + tempL + ", tempR = " + tempR);
                swap(chrs, tempL, tempR);

            }
        }
        return new String(chrs);
    }


    void swap(char[] chrs, int l, int r) {

        while (l < r) {
            char temp = chrs[r];
            chrs[r] = chrs[l];
            chrs[l] = temp;
            l++;
            r--;
        }
    }
}
