package io.sokovets.leetcode.easy.medium;

import java.util.PriorityQueue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointsToOrigin973 {

    public static void main(String[] args) {
        /*
        Input: points = [[1,3],[-2,2]], k = 1
        Output: [[-2,2]]
        Explanation:
        The distance between (1, 3) and the origin is sqrt(10).
        The distance between (-2, 2) and the origin is sqrt(8).
        Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
         */
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;//
        int[][] ints = new KClosestPointsToOrigin973().kClosest(points, k);
        System.out.println();

    }


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> compare(a, b)); //Log(N) - logorifmic time


        //Get all elements from array and set to priority queue
        for (int[] arr : points) {
            priorityQueue.add(arr);
        }

        //k = priorityQueue.size();
        int index = 0;
        int[][] result = new int[k][];
        while (!priorityQueue.isEmpty() && k > index) { //O(N)
            result[index] = priorityQueue.poll();
            index++;
        }

        return result;
    }

    //Our comparator
    private int compare(int[] a, int[] b) {
        return (a[0] * a[0] - b[0] * b[0]) + (a[1] * a[1] - b[1] * b[1]);
    }

    //Другое вид записи
//    int dist1(int[] a){
//        return a[0]*a[0]+a[1]*a[1];
//    }
//    int compare(int[] a, int[] b){
//        return dist(a) - dist(b);
//    }

}
