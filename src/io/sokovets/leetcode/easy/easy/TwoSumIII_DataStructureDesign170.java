package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;


/**
 * Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.
 *
 * Implement the TwoSum class:
 *
 * TwoSum() Initializes the TwoSum object, with an empty array initially.
 * void add(int number) Adds number to the data structure.
 * boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
 *
 *
 * Example 1:
 *
 * Input
 * ["TwoSum", "add", "add", "add", "find", "find"]
 * [[], [1], [3], [5], [4], [7]]
 * Output
 * [null, null, null, null, true, false]
 *
 * Explanation
 * TwoSum twoSum = new TwoSum();
 * twoSum.add(1);   // [] --> [1]
 * twoSum.add(3);   // [1] --> [1,3]
 * twoSum.add(5);   // [1,3] --> [1,3,5]
 * twoSum.find(4);  // 1 + 3 = 4, return true
 * twoSum.find(7);  // No two integers sum up to 7, return false
 */
public class TwoSumIII_DataStructureDesign170 {

    private Map<Integer, Integer> values;


    public TwoSumIII_DataStructureDesign170() {
        values = new HashMap<>();

    }

    public void add(int number) {
        values.merge(number, 1, Integer::sum);
    }

    public boolean find(int value) {
        if (values.isEmpty()) {
            return false;
        }

        if (values.size() == 1 && values.containsKey(value) && values.get(value) < 2) {

            return false;
        }

        for (Map.Entry<Integer, Integer> num : values.entrySet()) {

            int tryToFind = value - num.getKey();


            if (values.containsKey(tryToFind)) {

                if (num.getKey() == tryToFind && num.getValue() == 1) {
                    return false;
                }

                return true;
            }

        }

        return false;
    }
}
