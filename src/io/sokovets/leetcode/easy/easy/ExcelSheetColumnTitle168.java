package io.sokovets.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * ZY -> 701
 * ...
 */
public class ExcelSheetColumnTitle168 {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle168().convertToTitle(2081));
    }

    //Здесь нужно представить как расклыдывается число, если A = 1, AA = (26*1) + 1, AAA = 26 * (26 * 1 + 1) + 1 {}, ABC = 26 * (26 * 1 + 2) + 3,
    // AAAA = 26 * (26 * (26 * 1 + 1)) + 1,
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        //Записали все в Map. Сделали соотношение числа и символа. Идем от А,
        // следовательно сделали '+ i - 1', чтобы если стоим на единице в цикле, получить A.
        Map<Integer,Character> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) ('A' + i - 1));
        }


        //Дальше говоря пока columnNumber не будет равен 0, то идем в цикле и в конце пишем условие, которое будет сокращать n
        while (columnNumber != 0 ) {

            int a = columnNumber % 26 == 0 ? 26 : (columnNumber % 26);
            char letter = map.get(a);
            sb.append(letter);

            columnNumber = (columnNumber -1)/ 26;
        }

        //Вернем в обратном порядке наше значения, которые записали
        return sb.reverse().toString();
    }

}
