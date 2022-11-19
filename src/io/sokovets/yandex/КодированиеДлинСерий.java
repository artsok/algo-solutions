package io.sokovets.yandex;

import javax.xml.transform.Source;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A. Кодирование длин серий
 * Ограничение времени	2 секунды
 * Ограничение памяти	64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод	стандартный вывод или output.txt
 * Кодирование длин серий (RLE) — алгоритм сжатия данных, заменяющий повторяющиеся символы на один символ и число его повторов. Серией называется последовательность, состоящая из нескольких одинаковых символов (более одного). При кодировании строка одинаковых символов, составляющих серию, заменяется строкой, содержащей сам повторяющийся символ и количество его повторов.
 * <p>
 * Например, строка AAAABBB будет сжата в строку A4B3, а строка AAAAAAAAAAAAAAABAAAAA — в строку A15BA5.
 * <p>
 * Вам дана сжатая строка, найдите длину исходной строки.
 * Длина исходной строки не превосходит 1000 символов, все символы исходной строки заглавные большие буквы латинского алфавита.
 * <p>
 * Формат ввода
 * В единственной строке входных данных содержится непустая строка s. Гарантируется, что s результат корректного сжатия некоторой строки.
 * <p>
 * Формат вывода
 * Выведите длину исходной строки.
 */
public class КодированиеДлинСерий {


    public static void main(String[] args) {

        String input = "Z123XY";

        Queue<Integer> digits = new ArrayDeque<>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);
        while (m.find()) {
            digits.add(Integer.valueOf(m.group()));
        }

        StringBuilder decode = new StringBuilder();


        for (int i = 0; i < input.length(); i++) {

            if (Character.isLetter(input.charAt(i))) {
                int j = i + 1;
                if (j < input.length()) {
                    if (Character.isDigit(input.charAt(j))) {
                        int count = digits.poll();
                        for (int k = 0; k < count; k++) {
                            decode.append(input.charAt(i));
                        }
                    } else {
                        decode.append(input.charAt(i));
                    }
                } else {
                    decode.append(input.charAt(i));
                }
            }
        }

        System.out.println(decode.length());
    }

    public static void main1(String[] args) {
        //Scanner scan = new Scanner(System.in);

        String input = "A127A127A2";

        //String input = "A2A2A21A0"; //Answer: 26
        //String input = "Z123XY"; //125
        //String input = "A15BA5"; //Answer: 21

        //String input = "ABCDR";
        //String input = "ABCDR1";

//        while (scan.hasNext()) {
//            input = scan.next();
//        }


        int k = 0;
        int j = 1;


        long[] counts = new long[26];

        while (k <= input.length() - 1) {

            char ch = input.charAt(k);
            StringBuilder sb = new StringBuilder("1");
            StringBuilder sb2 = new StringBuilder("");

            while (j <= input.length() - 1 && Character.isDigit(input.charAt(j))) {
                sb2.append(input.charAt(j));
                j++;
                k = j - 1;
            }

            if (sb2.length() > 0) {
                long value = Long.parseLong(sb2.toString());
                counts[ch - 'A'] += value;
            } else {
                long value = Long.parseLong(sb.toString());
                counts[ch - 'A'] += value;
            }


            k++;
            j = k + 1;
        }

        long result = 0;

        for (long num : counts) {
            result += num;
        }

        System.out.println(result);


    }

}
