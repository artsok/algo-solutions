package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 * <p>
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord819 {

    public static void main(String[] args) {
        String a = "a?bc.";
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};


        System.out.println(new MostCommonWord819().mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.toLowerCase()
                .replaceAll(",", " ") //Забыл про этот случай
                .replaceAll("!", "")
                .replaceAll("\\?", "")
                .replaceAll("'", "")
                .replaceAll(";", "")
                .replaceAll("\\.", "")
                .replaceAll("\"", "")
                .replaceAll("  ", " ") //И вот этот ("a, a, a, a, b,b,b,c, c")
                .split(" ");

        for (String word : words) {
            map.merge(word.trim(), 1, Integer::sum);
        }


        for (String bannedWord : banned) {
            map.remove(bannedWord);
        }

        Map.Entry<String, Integer> commonEntry = null;
        int maxResult = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            int countWords = entry.getValue();

            if (countWords > maxResult) {
                maxResult = countWords;
                commonEntry = entry;
            }
        }

        return commonEntry.getKey();
    }
}
