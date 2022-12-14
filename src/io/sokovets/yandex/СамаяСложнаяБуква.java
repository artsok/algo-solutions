package io.sokovets.yandex;

/**
 * Василий решил улучшить свою скорость печати. Он заметил, что некоторые буквы на клавиатуре он ищет дольше, чем другие. Ему интересно, какую букву он искал дольше всего. Напишите программу, которая поможет Василию узнать это.
 * <p>
 * Василий ввел
 * N
 * N букв.
 * <p>
 * Строка
 * S
 * S – строка, введенная Василием, имеет длину
 * N
 * N.
 * <p>
 * Mассив
 * A
 * A содержит
 * N
 * N целых неотрицательных чисел, каждое число
 * A
 * i
 * A
 * i
 * ​
 * – время в миллисекундах от начала ввода до того как была напечатана
 * i
 * i-тая буква.
 * <p>
 * Считается, что Василий начал искать следующую букву сразу после того, как напечатал предыдущую. Букву с индексом 0 он искал
 * A
 * 0
 * A
 * 0
 * ​
 * миллисекунд.
 * <p>
 * При решении на языке Dart используйте ввод и вывод через файлы, стандартный поток ввода работает слишком медленно.
 *
 * Выведите букву, которую Василий искал дольше всего. Если букв с одинаковым временем поиска несколько, выведите ту, что он напечатал последней.
 */
public class СамаяСложнаяБуква {

    //Найти букву, которую он искал дольше всего
    //В первой строке входных данных находится N - количество введенных букв.
    //Во второй строке находится S – введенная строка, состоящая из N букв.
    //В третьей строке через пробел числа
    public static void main(String[] args) {
        //5
        //aabbc
        //1 3 5 7 8

        String c = "aaaa";




        int[] times = new int[]{1, 2, 4, 6};

        int[] dp = new int[times.length];



        dp[0] = times[0];
        int maxTime = dp[0];
        int charIndex = 0;

        for (int i = 1; i < times.length; i++) {
            dp[i] = times[i] - times[i - 1];

            if (dp[i] >= maxTime) {
                maxTime = dp[i];
                charIndex = i;
            }
        }

        System.out.println(c.charAt(charIndex));

    }

}
