package io.sokovets.leetcode.easy.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromeNumber9 {

    /*
        Идея с LT:
        For example, if the input is 1221, if we can revert the last part of the number "1221" from "21" to "12",
        and compare it with the first half of the number "12", since 12 is the same as 12, we know that the number is a palindrome.

        Брать половину значения нашего числа и сравнивать с двумя первыми.
     */


    //Follow up: Could you solve it without converting the integer to a string?
    public boolean isPalindromeWithOutString(int x) {
        if (x < 0) {
            return false;
        }

        //121 -> 1 2 1 ->

        List<Integer> list = new ArrayList<>();

        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }

        int l = 0;
        int r = list.size() - 1;

        while (l < r) {

            if (list.get(l) != list.get(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }



    public boolean isPalindrome(int x) {

        LinkedList<String> a = new LinkedList<>();
        

        if (x < 0) {
            return false;
        }

        String value = String.valueOf(x);
        return isPalindrome(value, 0, value.length() - 1);
    }

    boolean isPalindrome(String value, int l, int r) {
        while (l < r) {
            if (value.charAt(l) != value.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }

}
