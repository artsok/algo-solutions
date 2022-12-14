package io.sokovets.codeforces;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * В компании работает 𝑛 разработчиков, где 𝑛 — четное число. Сумасшедший менеджер решил разбить всех разработчиков на команды по два человека.
 * <p>
 * Для этого он составил список всех разработчиков и назначил каждому из них номер по списку (от 1 до 𝑛) и значение 𝑎𝑖 — уровень мастерства 𝑖-го в списке разработчика.
 * <p>
 * Очередную команду он составляет следующим образом:
 * <p>
 * первый разработчик в команде тот, кто идет первым в списке;
 * ему в пару подбирается такой, что разница их уровней минимальна (то есть минимально значение |𝑎𝑖−𝑎𝑗|, где |𝑥| — это модуль числа 𝑥); если таких кандидатов несколько, то выбирается из них тот, кто находится раньше в списке;
 * эти два разработчика образуют команду и удаляются из списка.
 * Например, если массив 𝑎 равен [2,1,3,1,1,4], то формирование команд будет происходить следующим образом:
 * <p>
 * назначим разработчикам номера [1,2,3,4,5,6] в соответствии с их положением в списке, первый среди них имеет номер 1, его уровень мастерства 𝑎1=2, подходящими (с минимальной абсолютной разностью) являются разработчики с номерами 2,3,4,5, первый среди них 2, таким образом первая команда — это разработчики с номерами 1 и 2;
 * оставшиеся разработчики теперь имеют номера [3,4,5,6], первый среди них 3, его уровень 𝑎3=3, разработчик с минимальной абсолютной разностью только один (номер 6), таким образом команда — разработчики с номерами 3 и 6;
 * оставшиеся разработчики имеют номера [4,5], первый среди них 4, его уровень 𝑎4=1, остался только разработчик с номером 5, таким образом третья команда — разработчики с номерами 4 и 5.
 * Ваша задача — помочь сумасшедшему менеджеру промоделировать процесс разбиения на команды. Обратите внимание, что команды должны быть выведены в порядке, описанном выше в условии.
 * <p>
 * Входные данные
 * Первая строка содержит одно целое число 𝑡 (1≤𝑡≤50) — количество наборов входных данных.
 * <p>
 * Первая строка каждого набора содержит одно целое число 𝑛 (2≤𝑛≤50; 𝑛 четное) — количество разработчиков.
 * <p>
 * Вторая строка содержит 𝑛 целых чисел 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤100), где 𝑎𝑖 — уровень мастерства 𝑖-го разработчика.
 * <p>
 * Выходные данные
 * Для каждого набора входных данных выведите 𝑛2 строк, 𝑖-я строка должна содержать пару чисел — номер первого и второго разработчика в 𝑖-й команде в порядке, описанном в условии.
 * <p>
 * Выводите пустую строку между выводами для наборов входных данных.
 * <p>
 * входные данные
 * 3
 * 6
 * 2 1 3 1 1 4
 * 2
 * 5 5
 * 8
 * 1 4 2 5 4 2 6 3
 * <p>
 * <p>
 * выходные данные
 * 1 2
 * 3 6
 * 4 5
 * <p>
 * 1 2
 * <p>
 * 1 3
 * 2 5
 * 4 7
 * 6 8
 */
public class ПарноеПрограммирование {

    public static void main(String[] args) {

        //int[] skills = new int[] {2, 1, 3, 1, 1, 4};
        //int[] skills = new int[] {1, 4, 2, 5, 4, 2, 6, 3};
        int[] skills = new int[] {5, 5};


        for (int i = 0; i < skills.length; i++) {

            int minIndex = Integer.MAX_VALUE;
            int minValue = Integer.MAX_VALUE;

            if (skills[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int k = i + 1; k < skills.length; k++) {
                if (skills[k] == Integer.MAX_VALUE) {
                    continue;
                }

                int diff = Math.abs(skills[i] - skills[k]);

                if (diff < minValue) {
                    minValue = diff;
                    minIndex = k;
                }


            }

            System.out.println("i " + (i + 1) + " k " + (minIndex + 1));

            skills[i] = Integer.MAX_VALUE;
            skills[minIndex] = Integer.MAX_VALUE;





        }


    }
}
