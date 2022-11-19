package io.sokovets.codesignal;

import java.util.HashMap;

/**
 * Given a year, return the century it is in.
 * The first century spans from the year 1 up to and including the year 100,
 * the second - from the year 101 up to and including the year 200, etc.
 *
 * Example
 *
 * For year = 1905, the output should be
 * solution(year) = 20;
 * For year = 1700, the output should be
 * solution(year) = 17.
 */
public class CenturyFromYear {

    /**
     * Метод Math.floor() — дает целое число с нулевой дробной частью, ближайшее к числу аргумента слева,
     * другими словами — округляет дробь в меньшую сторону.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new CenturyFromYear().solution(170));
    }

    int solution(int year) {
        year = (int) Math.floor((year -1) / 100) +1;
        return year;
    }
}
