package io.sokovets.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSum {


    public static void miniMaxSum(List<Integer> arr) {

        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            long temp = sum - arr.get(i);

            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }

        System.out.print(min + " ");
        System.out.print(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        MiniMaxSum.miniMaxSum(arr);
        bufferedReader.close();
    }
}
