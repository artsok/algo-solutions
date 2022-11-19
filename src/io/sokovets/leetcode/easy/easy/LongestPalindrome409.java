package io.sokovets.leetcode.easy.easy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 * <p>
 * Input: s = "a"
 * Output: 1
 * Example 3:
 * <p>
 * Input: s = "bb"
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPalindrome409 {

    public static void main(String[] args) {

        System.out.println(new LongestPalindrome409().longestPalindrome("abccccdd"));

        System.out.println(new LongestPalindrome409().longestPalindromeShort("abccccdd"));
    }


    public int longestPalindromeShort(String s) {
        int[] count = new int[128]; //Потому-что максимум по ASCII хранит в себе 7 битов и это 128
        int length = 0;
        for (char c : s.toCharArray()) {
            if (++count[c] == 2) {
                length += 2;
                count[c] = 0;
            }
        }
        return (length == s.length()) ? length : length + 1;
    }


    public int longestPalindromeWithConcurrentMap(String s) {
        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> map = new ConcurrentHashMap<>();


        for (char character : s.toCharArray()) {
            map.merge(character, 1, Integer::sum);
        }

        int maxLength = 0;


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int totalNumberOfCharacters = entry.getValue();
            maxLength += (totalNumberOfCharacters / 2) * 2;

            if (totalNumberOfCharacters % 2 == 0) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), totalNumberOfCharacters % 2);
            }
        }



        if (map.size() > 0) {
            maxLength += 1;
        }

        return maxLength;
    }

    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();


        for (char character : s.toCharArray()) {
            map.merge(character, 1, Integer::sum);
        }

        int maxLength = 0;

        boolean addLast = false;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int totalNumberOfCharacters = entry.getValue();
            maxLength += (totalNumberOfCharacters / 2) * 2;

            if (totalNumberOfCharacters % 2 != 0) {
                addLast = true;
            }
        }

        if (addLast) {
            maxLength += 1;
        }

        // if (s.length()%2 != 0) {
        //     maxLength += 1;
        // }

        return maxLength;
    }


    List<String> generateAllWords(String a) {

        List<int[]> memo = new ArrayList<>();

        int l = 0;
        int r = a.length();
        while (l < r) {
            String substring = a.substring(l, r);
            int[] index = new int[substring.length()];
            Arrays.setAll(index, i -> i);
            perm(index, index.length, memo);
            l++;
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int[] words : memo) {

            for (int i = 0; i < words.length; i++) {
                sb.append(a.charAt(words[i]));
            }
            result.add(sb.toString());
            sb.delete(0, words.length);
        }

        return result;
    }

    void perm(int[] lst, int n, List<int[]> hashSet) {
        int[] copy = Arrays.copyOf(lst, lst.length);
        if (n == 1) {
            hashSet.add(copy);
        } else {
            for (int j = n - 1; j >= 0; j--) {
                swap(lst, j, n - 1);
                perm(lst, n - 1, hashSet);
                swap(lst, j, n - 1);
            }
        }
    }

    public final void swap(int[] a, int i, int j) {
        if (i >= 0 && j >= 0) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }


    private int countLength(int r, int l, String s) {
        if (isPalaindrom(r, l, s)) {
            return l - r;
        }
        return 0;
    }

    public int longestPalindrome_ItsNotForThatTask(String s) {
        //s = "abccccdd"


        List<String> strings = generateAllWords(s);
        int maxLength = 0;

        for (String str : strings) {
            if (isPalaindrom(0, str.length() - 1, str)) {
                maxLength = Math.max(maxLength, str.length());
            }
        }

        return maxLength;
    }

    private boolean isPalaindrom(int l, int r, String s) {
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
