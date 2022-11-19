package io.sokovets.leetcode.easy.medium;

import java.util.*;

public class TopKFrequentElements347 {

    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> mem = new HashSet<>();


    public static void main(String[] args) {
        new TopKFrequentElements347().topKFrequent(new int[]{2, 1, 1, 1, 1,  2, 2, 4}, 2);
    }


    int comparator(int a, int b) {
        int aCount = map.get(a);
        int bCount = map.get(b);

        return Integer.compare(bCount, aCount);
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> comparator(a, b));

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }


        for (int num : nums) {
            if (!mem.contains(num)) {
                mem.add(num);
                pq.add(num);
            }

        }

        int[] answer = new int[k];

        while (k != 0) {
            answer[k - 1] = pq.poll();
            k--;
        }

        return answer;

    }

}
