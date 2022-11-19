package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs70 {

    static Map<Integer, Integer> mem = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs70().climbStairs(45));
    }


    public int climbStairs(int n) {
        //Should to use memorization
        //F(N) = F(N-1) + F(N-2)
        if (mem.containsKey(n)) {
            return mem.get(n);
        }

        if (n == 1) {
            return 1;
        } else if (n == 2 ) {
            return 2;
        }

        int res = climbStairs(n - 1) + climbStairs(n - 2);
        mem.putIfAbsent(n, res);

        return res;
    }
}
