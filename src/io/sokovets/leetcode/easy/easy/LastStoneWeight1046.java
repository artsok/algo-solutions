package io.sokovets.leetcode.easy.easy;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 */
public class LastStoneWeight1046 {

    public static void main(String[] args) {
        int[] stones = {2,7,4,3};
        int weight = new LastStoneWeight1046().lastStoneWeight(stones);
        System.out.println("weight = " + weight);

    }

    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b -a );

        for(int stone : stones) {
            pq.add(stone); //O(N)
        }

        //8,7,4,2,1
        while(pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int newWeight = stone1 - stone2;
            if (newWeight > 0) {
                pq.add(newWeight);
            }
        }

        if (pq.size() == 0) {
            return 0;
        }

        return pq.poll();

    }
}

/**
 * public int lastStoneWeight(int[] stones) {
 *         PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
 *         for(int stone : stones) pq.add(stone);
 *         while(pq.size() > 1) {
 *             int item1 = pq.remove();
 *             int item2 = pq.remove();
 *             if(item1 != item2) {
 *                 pq.add(Math.abs(item1 - item2));
 *             }
 *         }
 *         return pq.isEmpty() ? 0 : pq.remove();
 *     }
 */
