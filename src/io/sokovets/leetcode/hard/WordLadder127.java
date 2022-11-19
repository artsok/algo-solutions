package io.sokovets.leetcode.hard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
public class WordLadder127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //beginWord:hit -> на каждый символ сгенерить от a-z

        Map<String, List<String>> adjacentPairs = getAdjacentPairs(
                Stream.of(wordList, Arrays.asList(beginWord)).flatMap(it -> it.stream()).collect(Collectors.toSet()));

        Queue<String> queue = new ArrayDeque<>();

        Set<String> visited = new HashSet<>();

        int count = 0;

        queue.add(beginWord);

        while (!queue.isEmpty()) {
            //hit -> [hot - только то что есть из списка]

            for (int k = queue.size(); k >= 1; k--) { //Размер очереди будет меняться. Нужно идти от размера

                String newWord = queue.poll();

                //Если это убрать, то будет подсчет самого длинного пути
                if (newWord.equals(endWord)) {
                    return count + 1; //Надо приростить.
                }

                visited.add(newWord);

                List<String> list = adjacentPairs.get(newWord);

                for (String str : list) {
                    if (!visited.contains(str)) {
                        queue.add(str);
                    }
                }
            }

            count++;
        }

        //а здесь возвращать count

        return 0;
    }


    //Метод который генерит все возможные комбинации.
    // Например для hit - будет перебирать все символы для первого индекса, переберить все значения для второго индекса и для третьго
    Map<String, List<String>> getAdjacentPairs(Set<String> set) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : set) {
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();


                for (char a = 'a'; a <= 'z'; a++) {
                    if (chars[i] != a) {
                        chars[i] = a;
                        map.putIfAbsent(word, new ArrayList<>());

                        String generatedWord = new String(chars);
                        if (set.contains(generatedWord)) {
                            map.get(word).add(generatedWord);     //Для каждого слова у меня будет набор возможных переходов из списка wordList (adjacent list)
                        }
                    }
                }
            }
        }
        return map;
    }
}
