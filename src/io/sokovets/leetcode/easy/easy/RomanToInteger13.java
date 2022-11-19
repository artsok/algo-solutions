package io.sokovets.leetcode.easy.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInteger13 {



    public static void main(String[] args) { //1994
        Map<String, Integer> map = new HashMap<>();



        System.out.println(new RomanToInteger13().romanToInt("MCMXCIV"));
    }


    public int romanToInt(String s) {
        int prev = 1000;
        int current = 0;
        int x = 0;
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
                'C', 100, 'D', 500, 'M', 1000);

        for (int i = 0; i < s.length(); i++) {
            current = map.get(s.charAt(i));
            if (current > prev) {
                x = x - prev + (current - prev);
                prev = current;
            } else {
                x = x + current;
                prev = current;
            }
        }
        return x;
    }


//    public int romanToInt(String s) {
//        Map<String, Integer> romanNumerals = new LinkedHashMap<>();
//        romanNumerals.put("CM", 900);
//        romanNumerals.put("CD", 400);
//        romanNumerals.put("XC", 90);
//        romanNumerals.put("XL", 40);
//        romanNumerals.put("IX", 9);
//        romanNumerals.put("IV", 4);
//        romanNumerals.put("D", 500);
//        romanNumerals.put("M", 1000);
//        romanNumerals.put("C", 100);
//        romanNumerals.put("L", 50);
//        romanNumerals.put("X", 10);
//        romanNumerals.put("V", 5);
//        romanNumerals.put("I", 1);
//
//        int result = 0;
//
//        while (!s.isEmpty()) { //O(1) 15symbol
//            for (String key : romanNumerals.keySet()) { //O(1)
//                if (s.contains(key)) {
//                    s = s.replaceFirst(key, "");
//                    result += romanNumerals.get(key);
//                    romanNumerals.remove(key);
//                }
//            }
//        }
//        return result;
//    }
}
