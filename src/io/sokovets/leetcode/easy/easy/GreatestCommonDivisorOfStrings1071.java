package io.sokovets.leetcode.easy.easy;

import java.util.*;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t
 * (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
public class GreatestCommonDivisorOfStrings1071 {

    public static void main(String[] args) {
        //String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        //String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";

        String s = new GreatestCommonDivisorOfStrings1071().gcdOfStrings("ABABABAB", "ABAB");
        System.out.println(s);
    }

    public String gcdOfStrings(String str1, String str2) {

        //Делаем, так чтобы всегда короткая строка была первая
        if (str1.length() > str2.length()) {
            return gcdOfStrings(str2, str1); //меняем местами
        }

        String subString = "";
        String result = "";

        char[] chars = str1.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            subString += chars[i];
            String s = str1.replaceAll(subString, "");
            if (s.length() == 0) { //Проверяем, можем ли заменить всю строку найденными символами.
                s = str2.replaceAll(subString, ""); ////Проверям: можем ли заменить найденной подстрокой вторую строку
                if (s.length() == 0) {
                    result = subString; //заносим результат в ответ
                }

            }
        }
        return result;
    }

}

/**
 * char[] strArray1 = str1.toCharArray(); //A,B,C,
 * char[] strArray2 = str2.toCharArray(); //A,B,C
 * <p>
 * String result = "";
 * int size = 0;
 * <p>
 * if (strArray1.length > strArray2.length) {
 * size = strArray1.length - strArray2.length;
 * for (int i = 0; i < size; i++) {
 * if (strArray1[i] == strArray2[i]) {
 * result += strArray2[i];
 * }
 * }
 * // "ABCDEF"
 * // "ABC"
 * <p>
 * String substring = str1.substring(size, size + size);
 * if (substring.equals(result)) {
 * return result;
 * } else {
 * return "";
 * }
 * } else {
 * size = strArray2.length - strArray1.length;
 * for (int i = 0; i < size; i++) {
 * if (strArray1[i] == strArray2[i]) {
 * result += strArray1[i];
 * }
 * }
 * <p>
 * String substring = str2.substring(size, size + size);
 * if (substring.equals(result)) {
 * return result;
 * } else {
 * return "";
 * }
 * }
 */