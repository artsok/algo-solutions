package io.sokovets.leetcode.easy.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */


/**
 * NOTE: WHAT APPROACH TO USE?
 * <p>
 * Outer loop to move R to right
 * Update inventory, if required
 * Inner loop to move L to Right, if required
 * Save current answer to best answer, if requred
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        /*Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.*/

        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("pwwkew"));

    }
    //                   ^
    ///*Input: s = "abcabcbb"
    //                     ^
    //What my windowLength =
    //pwwkew
    //"dvdf"

    public int lengthOfLongestSubstring(String s) {

        Set<Character> characterSet = new HashSet<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (left < s.length() && characterSet.contains(ch)) {
                characterSet.remove(s.charAt(left));
                left++;
            }
            characterSet.add(ch);
            answer = Math.max(answer, characterSet.size());
        }

        return answer;
    }


}

/**
 * Set<Character> set = new HashMap<>();
 * int left = 0;
 * int N = s.length();
 * int ans = 0;
 *
 * for (int right = 0; right < N; right++) {
 * 	char ch = s.charAt(right);
 * 	while(l < N && set.contains(ch)) { //Пока содержит право будем двигать левый указатель
 * 		set.remove(s.chartAt(l));  //Пока цикл содержит крутим левый и удаляем
 * 		l++;
 *
 *        }
 * 	    set.add(ch);
 * 		ans = Math.max(ans, set.size);
 * 	return ans;
 *
 * }
 */
