package io.sokovets.leetcode.easy.easy;


import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 * <p>
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * <p>
 * Return names sorted in descending order by the people's heights.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 * Explanation: Mary is the tallest, followed by Emma and John.
 * Example 2:
 * <p>
 * Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * Output: ["Bob","Alice","Bob"]
 * Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 */
public class SortThePeople2418 {

    public static void main(String[] args) {
        List<String> names = List.of("Mary", "John", "Emma");
        List<Integer> heights = List.of(180, 165, 170);

    }

    public String[] sortPeopleOriginal(String[] names, int[] heights) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < names.length; i++) {
            Map.Entry<String, Integer> entry = Map.entry(names[i], heights[i]);
            pq.add(entry);
        }

        String[] answer = new String[names.length];
        int index = 0;

        while (!pq.isEmpty()) {
            answer[index] = (pq.poll().getKey());
            index++;
        }

        return answer;
    }


    //Не подходит
    public String[] sortPeople(String[] names, int[] heights) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            map.put(names[i], heights[i]);
        }

        String[] collect = map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        return collect;
    }

}
