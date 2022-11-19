package io.sokovets.leetcode.easy.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman12 {

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static void main(String[] args) {

    }

    public String intToRomanLP(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }





    //TimeComplexity = O(N)
    //SpaceComplexity = O(N)
    public String intToRoman(int num) {
        int n = num;

        Map<Integer,String> roman = new LinkedHashMap<>();
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        Map<Integer, String> roman2 = new LinkedHashMap<>();
        roman2.put(90, "XC");
        roman2.put(50, "L");
        roman2.put(40, "XL");
        roman2.put(10, "X");

        Map<Integer,String> roman3 = new LinkedHashMap<>();
        roman3.put(900, "CM");
        roman3.put(500, "D");
        roman3.put(400, "CD");
        roman3.put(100, "C");


        Map<Integer,String> roman4 = new LinkedHashMap<>();
        roman4.put(1000, "M");

        //Наблюдение: определить в какой диапозон входит число, брать максимальное число и отнимать от n. Идти пока n не станет равно 0.

        //8-5=3   V

        StringBuilder result = new StringBuilder();

        while (n != 0) {
            int length = String.valueOf(n).length();

            if (length == 2) {
                for (int value : roman2.keySet()) {
                    if (n >= value) {
                        result.append(roman.get(value));
                        n -= value;
                    }
                }
            } else if (length == 3) {
                for (int value : roman3.keySet()) {
                    if (n >= value) {
                        result.append(roman.get(value));
                        n -= value;
                    }
                }
            } else if (length == 4) {
                for (int value : roman4.keySet()) {
                    if (n >= value) {
                        result.append(roman.get(value));
                        n -= value;
                    }
                }
            } else {
                for (int value : roman.keySet()) {
                    if (n >= value) {
                        result.append(roman.get(value));
                        n -= value;
                    }
                }
            }
        }

        return result.reverse().toString();
    }
}
