package io.sokovets.leetcode.easy.medium;

import java.util.*;


/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency451 {

    public String frequencySort(String s) {


        //1.Make map with frequency of characters
        //2.while map size != 0, we try to find max count for character
        //3.Add character to StringBuilder as map value, and delete charater from map

        //1.Make map with frequency of characters
        //2.Make the priorityQueue
        //3.Iterate map and add entry to PQ. Use comparator that checks counts and order entry
        //4.Get first entry with max count from PQ and add it to SB

        Map<Character,Integer> map = new HashMap<>();

        for (char character : s.toCharArray()) {
            map.merge(character, 1, Integer::sum);
        }

        //t-{1}, r-{1}, e-{2}

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b) -> comparator(a, b));
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        //t-{1}, r-{1}, e-{2}


        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {

            Map.Entry<Character,Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();

    }

    int comparator(Map.Entry<Character,Integer> a, Map.Entry<Character,Integer> b) {
        int countA = a.getValue();
        int countB = b.getValue();
        return countB - countA;
    }



    public String frequencySortFromLeetcode(String s) {

        // Count up the occurances.
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Make a list of the keys, sorted by frequency.
        List<Character> characters = new ArrayList<>(counts.keySet());
        Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));

        // Convert the counts into a string with a sb.
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            int copies = counts.get(c);
            for (int i = 0; i < copies; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}



