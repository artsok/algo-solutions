package io.sokovets.yandex9;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Вася начал изучать кодирование. В этот раз он изобрёл свой шифр, который меняет каждый символ
 * строки по следующему правилу:
 * <p>
 * Символы с «a» по «i» отображаются в числа от «1» до «9» соответственно
 * <p>
 * Символы с «j» по «z» отображаются в числа от «10#» до «26#» соответственно
 * <p>
 * Например, строка «hello» по этому правилу будет закодирована последовательностью «8512#12#15#».
 * <p>
 * Вася научился кодировать строки. А вот с раскодированием у него проблемы. Помогите Васе
 * раскодировать строку!
 * <p>
 * Формат ввода В первой строке дана закодированная последовательность s s ( 1 ≤ ∣ s ∣ ≤ 100
 * 1≤∣s∣≤100), состоящая из цифр и символа «#».
 * <p>
 * Гарантируется, что последовательность получена кодированием какой-то исходной строки, состоящей
 * из строчных латинских букв.
 * <p>
 * Формат вывода Выведите единственную строку — раскодированную последовательность s s.
 */
public class РаскодируйCтроку {

  public static void main(String[] args) {

    //String a = "8512#12#15#23#15#18#12#4";
    //String a = "1212#";
    String a = "9";
    char[] charArray = a.toCharArray();

    StringBuilder result = new StringBuilder();


    Map<Integer, String> decoderMap =
        IntStream.rangeClosed(1, 26)
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                i -> String.valueOf((char) ('a' + i - 1))
            ));

    for (int i = charArray.length - 1; i >= 0; i--) {
      if (charArray[i] == '#') {
        String symbol = decoderMap.get((charArray[i-2] - '0') * 10 + (charArray[i-1] - '0'));
        result.append(symbol);
        i -= 2;
      } else {
        String symbol = decoderMap.get(charArray[i] - '0');
        result.append(symbol);
      }
    }

    System.out.println(result.reverse().toString());
  }

}
