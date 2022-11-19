package io.sokovets.leetcode.easy.easy;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * <p>
 * Input: s = "God Ding"
 * Output: "doG gniD"
 */
public class ReverseWordsInaStringIII557 {

    public static void main(String[] args) {

    }


    public String reverseWordsLeetCode(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

    public String reverseWords(String s) {

        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            char[] chars = word.toCharArray();
            swap(chars, 0, word.length() - 1);
            sb.append(chars);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    void swap(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[r];
            chars[r] = chars[l];
            chars[l] = temp;
            l++;
            r--;
        }
    }
}
