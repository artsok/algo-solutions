package io.sokovets.leetcode.easy.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz412 {

    public List<String> fizzBuzz(int n) {

        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");


        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            for (Map.Entry<Integer, String> entry : map.entrySet()) {

                int divisibleBy = entry.getKey();

                if (i % divisibleBy == 0) {
                    if (divisibleBy == 3) {
                        sb.append("Fizz");
                    }
                    if (divisibleBy == 5) {
                        sb.append("Buzz");
                    }
                }
            }

            if (sb.length() == 0) {
                sb.append(i);
            }

            list.add(sb.toString());
            sb.delete(0, sb.length());
        }

        return list;
    }


    public List<String> fizzBuzzBasicIdea(int n) {

        //1. Iterate from 1 until n
        //2.  Check
        //3.1 if (i%3 == 0 && i%5 == 0), continue
        //3.2 if (i%3 == 0)
        //3.3 if (i%5 == 0)
        //4. add result to List<String>

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {


            boolean res = helper(i, 3);
            boolean res1 = helper(i, 5);

            if (res && res1) {
                result.add("FizzBuzz");
                continue;
            } else if (res1) {
                result.add("Buzz");
                continue;
            } else if (res) {
                result.add("Fizz");
                continue;
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    boolean helper(int a, int k) {
        while (a > 0) {
            a -= k;
        }

        return a == 0 ? true : false;
    }
}
