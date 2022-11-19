package io.sokovets.leetcode.easy.easy;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: false
 */
public class ValidPalindromeII680 {


    public static void main(String[] args) {
        //System.out.println(new ValidPalindromeII680().validPalindrome("acdca"));
        //System.out.println(new ValidPalindromeII680().validPalindrome("pidbliassaqozokmtgahluruufwbjdtayuhbxwoicviygilgzduudzgligyviciowxbhuyatdjbwfuurulhagtmkozoqassailbdip"));
        //System.out.println(new ValidPalindromeII680().validPalindrome("abc"));

        System.out.println(new ValidPalindromeII680_Copy().validPalindrome("abccccdd"));
    }

    public boolean validPalindrome(String s) {
        //Как понять что нужно удалить? abca
        int left = 0; //идем с лева;
        int right = s.length() - 1; //идем с права;

        //acda
        // ^^
        //aca
        //ada

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {

                StringBuilder sb = new StringBuilder(s);
                String replace = sb.deleteCharAt(left).toString();

                StringBuilder sb1 = new StringBuilder(s);
                String replace2 = sb1.deleteCharAt(right).toString();


                return isPalindrome(replace, 0, replace.length()-1) || isPalindrome(replace2, 0, replace2.length()-1);
            }
            left++;
            right--;
        }
        return true;
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}


/**
 * Решение от LeetCode
 */

class ValidPalindromeII680_Copy {
    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(i) != s.charAt(j)) {
                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
            }

            i++;
            j--;
        }

        return true;
    }
}