package io.sokovets.leetcode.easy.easy;

import java.util.*;

public class CheckIfTheSentenceIsPangram1832 {
    public static void main(String[] args) {
        List<String> a = Arrays.asList("the ", "quickk", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
        System.out.println(new CheckIfTheSentenceIsPangram1832().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }

    public int solve(List<String> A) {
        Set<Character> alphabets = new HashSet<>();
        for (String string : A) {
            char[] sentence = string.toCharArray();
            for(char symbol : sentence) {
                if (symbol != ' ') {
                    alphabets.add(symbol);
                }
            }
        }
        System.out.println(alphabets.size());
        if (alphabets.size() == 26) {
            return 1;
        }
        return 0;
    }

    public boolean checkIfPangram(String sentence) {
        int i = 0;
        sentence = sentence.toLowerCase();
        for (char a = 'a'; a <= 'z'; a++) {
            if (sentence.contains(String.valueOf(a))) {
                i++;
            }
        }
        return i == 26;
    }




}
