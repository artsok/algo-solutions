package io.sokovets.codility;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Write a program which takes two strings as input from the user (str1 and str2). This program should print two strings as output (op1 and op2).
 *
 * op1 should contain all the characters which are present in str1 but NOT present in str2
 *
 * op2 should contain all the characters which are present in str2 but NOT present in str1
 */

//https://www.geeksforgeeks.org/find-uncommon-characters-two-strings/
public class FindUncommonCharactersTwoStrings {

    public static void main(String[] args) {
        String str1 = "characters";
        String str2 = "alphabets";

        Map<Character, Integer> strMap1 = new LinkedHashMap<>();
        for (char ch : str1.toCharArray()) {
            strMap1.merge(ch, 1, Integer::sum);
        }

        Map<Character, Integer> strMap2 = new LinkedHashMap<>();
        for (char ch : str2.toCharArray()) {
            strMap2.merge(ch, 1, Integer::sum);
        }

        //op1 should contain all the characters which are present in str1 but NOT present in str2
        for (char ch : str2.toCharArray()) {
            strMap1.merge(ch, -1, Integer::sum);
        }

        //op2 should contain all the characters which are present in str2 but NOT present in str1
        for (char ch : str1.toCharArray()) {
            strMap2.merge(ch, -1, Integer::sum);
        }

        StringBuilder op1 = new StringBuilder("");
        StringBuilder op2 = new StringBuilder("");

        for (Map.Entry<Character, Integer> entry : strMap1.entrySet()) {
            if (entry.getValue() >= 1) {
                op1.append(entry.getKey());
            }
        }

        for (Map.Entry<Character, Integer> entry : strMap2.entrySet()) {
            if (entry.getValue() >= 1) {
                op2.append(entry.getKey());
            }
        }
        System.out.println(op1);
        System.out.println(op2);
    }

}
