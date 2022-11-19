package io.sokovets.leetcode.easy.easy;

import java.util.*;

/**
 * You are given a 0-indexed string word, consisting of lowercase English letters. You need to select one index and remove the letter at that index from word so that the frequency of every letter present in word is equal.
 * <p>
 * Return true if it is possible to remove one letter so that the frequency of all letters in word are equal, and false otherwise.
 * <p>
 * Note:
 * <p>
 * The frequency of a letter x is the number of times it occurs in the string.
 * You must remove exactly one letter and cannot chose to do nothing.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word = "abcc"
 * Output: true
 * Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
 * Example 2:
 * <p>
 * Input: word = "aazz"
 * Output: false
 * Explanation: We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" is 2, or vice versa. It is impossible to make all present letters have equal frequency.
 */
public class RemoveLetterToEqualizeFrequency2423 {


    public static void main(String[] args) {
        RemoveLetterToEqualizeFrequency2423 removeLetterToEqualizeFrequency2423 = new RemoveLetterToEqualizeFrequency2423();
        //System.out.println(removeLetterToEqualizeFrequency2423.equalFrequency("aabbb"));
        //System.out.println(removeLetterToEqualizeFrequency2423.equalFrequency("aabb"));
        //System.out.println(removeLetterToEqualizeFrequency2423.equalFrequency("abcc")); //Expected: true
        System.out.println(removeLetterToEqualizeFrequency2423.equalFrequency("bac"));
    }


    public boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        //Count characters
        //define unic characters
        for (char ch : word.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
            set.add(ch);
        }


        //Iterate through unique characters
        for (char ch : set) {
            Map<Character, Integer> copyMap = new HashMap<>(map); //Create every time copy of Map
            copyMap.merge(ch, -1, Integer::sum); //For every character decreased count

            if (copyMap.get(ch) == 0) { //If count of character becaome 0, delete it from map
                copyMap.remove(ch);
            }

            //Check is frequency unic for all characters when make one deletion
            Set<Integer> freq = new HashSet<>(copyMap.values());
            if (freq.size() == 1) {
                return true;
            }
        }

        return false;
    }

    public boolean equalFrequencyOLD(String word) {


        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        //Count characters
        //define unic characters
        for (char ch : word.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
            set.add(ch);
        }


        //Iterate through unique characters
        for (char ch : set) {
            Map<Character, Integer> copyMap = new HashMap<>(map); //Create every time copy of Map
            copyMap.merge(ch, -1, Integer::sum); //For every character decreased count

            if (copyMap.get(ch) == 0) { //If count of character becaome 0, delete it from map
                copyMap.remove(ch);
            }




            //Define minimum frequency
            int minCurrentFreq = Collections.min(copyMap.values());

            int index = 0;

            for (Map.Entry<Character, Integer> entry : copyMap.entrySet()) {

                //If count of character equals the minimum frequency increase index
                if (entry.getValue() == minCurrentFreq) {
                    index++;
                }
            }

            //Iterate through all entry and check if frequency is common for every character
            //If not set index to 0
            if (index == copyMap.size()) {
                return true;
            } else {
                index = 0;
            }
        }

        return false;
    }
}
