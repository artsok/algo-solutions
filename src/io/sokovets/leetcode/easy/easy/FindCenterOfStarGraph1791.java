package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * Правильное решение
 * public int findCenter(int[][] edges) {
 * 		if(edges[0][0]==edges[1][0] || edges[0][0]==edges[1][1]) return edges[0][0];
 * 		return edges[0][1];
 *  }
 */






/**
 * There is an undirected star graph consisting of n nodes labeled from 1 to n.
 * A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
 * Example 2:
 *
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * The given edges represent a valid star graph.
 */
public class FindCenterOfStarGraph1791 {

    Map<Integer,Integer> map = new HashMap<>();


    public static void main(String[] args) {
        int [][] a = new int[][] {{1,3}, {2,3}};
        new FindCenterOfStarGraph1791().findCenter(a);

        //[[1,2],[5,1],[1,3],[1,4]]
     }

    public int findCenter(int[][] edges) {
        for (int[] edge : edges) {

            int point1 = edge[0];
            int point2 = edge[1];

            if (map.containsKey(point1)) {
                map.merge(point1, 1, Integer::sum);
            } else if (map.containsKey(point2)) {
                map.merge(point2, 1, Integer::sum);
            } else {
                map.put(point1, 0);
                map.put(point2, 0);
            }

            if (map.size() > 3 ) {
                break;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 1) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
