package io.sokovets.yandex9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Олигополия {

  private static int findMax(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }

    int max = numbers[0];

    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }

    return max;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

    StringBuilder result = new StringBuilder();

    //String line1 = reader.readLine();
    //String line2 = reader.readLine();

    String line1 = "4";
    String line2 = "1 1 3 4";

    int countRow = Integer.valueOf(line1);

    //Когда у нас на входе 1 компания, тогда она победитель
    if (countRow == 1) {
      result.append(1);
    } else {

      String[] numbersAsString = line2.split(" ");
      int[] numbers = new int[numbersAsString.length];

      Deque<Integer> stack = new ArrayDeque<>(); //double ended queue
      Map<Integer, Integer> map = new HashMap<>(); //frequency count

      for (int i = 0; i < numbersAsString.length; i++) {
        int number = Integer.parseInt(numbersAsString[i]);
        numbers[i] = number;
        stack.push(number);
        map.merge(number, 1, Integer::sum);
      }

      //Когда все числа одинаковые
      if (map.size() == 1) {
        map.forEach((k,v) -> result.append(0).append("\n"));
      }


      //1 1 3 4
      for (int i = numbers.length - 1; i > 0; i--) {

        if (numbers[i] == numbers[i - 1]) {

          int value = numbers[i];
          int count = 1;

          while (i > 0 && numbers[i] == numbers[i - 1]) {
            count++;
            i--;
          }

          System.out.println("value = " + value + ", count = " + count);
        }

        result.append(1).append("\n");
      }



    }

    System.out.println(result.reverse().toString());

    reader.close();
    writer.close();
  }

}
