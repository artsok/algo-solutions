package io.sokovets.yandex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Тур по городу N для Кати, Маши и Наташи будет удачным, если они посмотрят самые ожидаемые достопримечательности в нужном порядке. Составьте кратчайшую последовательность достопримечательностей для посещения, чтобы пожелания были выполнены.
 * Даны три последовательности чисел. В любой из последовательностей числа могут повторяться.
 * Вам нужно найти супер-последовательность. Супер-последовательность – это последовательность минимальной длины, чтобы в ней были все три последовательности непрерывными фрагментами.
 * <p>
 * Формат ввода
 * Ввод состоит из трех строк. Первый элемент каждой строки
 * n
 * i
 * (
 * 1
 * ≤
 * n
 * i
 * ≤
 * 1
 * 0
 * 0
 * ) – число элементов в
 * i
 * -й последовательности. Далее идут
 * n
 * i
 * положительных чисел, не превосходящих 100, – элементы последовательности. Все числа в строках разделены пробелами.
 * Формат вывода
 * Первая строка вывода содержит одно число
 * k
 * – длина супер-последовательности.
 * Вторая строка содержит
 * k
 * разделенных пробелами чисел – элементы супер-последовательности.
 */
public class BestPlace_28_10_2022 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] kate = {"1", "2"};
        String[] miha = {"2", "1", "2"};
        String[] nataha = {"3", "3", "1", "2"};

        //Сохраним в мапке наш стартовый элемент и последовательность
        Map<Integer, int[]> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 1; i++) {
            int[] kateInt = Arrays.stream(kate)
                    .skip(1)
                    .mapToInt(Integer::parseInt).toArray();

            map.put(kateInt[0], kateInt);
        }

        for (int i = 0; i < 1; i++) {
            int[] mihaInt = Arrays.stream(miha)
                    .skip(1)
                    .mapToInt(Integer::parseInt).toArray();

            map.put(mihaInt[0], mihaInt);
        }

        for (int i = 0; i < 1; i++) {
            int[] natahaInt = Arrays.stream(nataha)
                    .skip(1)
                    .mapToInt(Integer::parseInt).toArray();

            map.put(natahaInt[0], natahaInt);
        }


        //2 1 2
        //2 2 3
        //2 3 1
        //В мапке будет {1 - {1,2}}, {2 - {2,3}}, {3 - {3,1}}

        //Идем от меньшего к большему
        int firstPlace = Collections.min(map.keySet());

        int[] currentWay = map.get(firstPlace);

        Deque<Integer> result = new ArrayDeque<>();

        //Добавили в результат путь
        for (int temp : currentWay) {
            result.add(temp);
        }

        map.remove(firstPlace);


        //Нужно идти пока не будет ключа
        while (map.containsKey(result.getLast())) {
            int key = result.pollLast();
            int[] ways = map.get(key);
            for (int i = 0; i < ways.length; i++) {
                result.add(ways[i]);
            }
            map.remove(key);
        }

        //Проверить, что map пустая
        if (map.size() == 0) {
            printResult(result);
        } else {
            //То мы либо добавляем вперед, либо назад
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                //{3, 1, 2}
                List<Integer> temp = Arrays.stream(entry.getValue()).boxed().sorted().collect(Collectors.toList());
                List<Integer> list = result.stream().sorted().collect(Collectors.toList());
                temp.removeAll(list);

                for (int i = 0; i < temp.size(); i++) {
                    result.addFirst(temp.get(i));
                }
            }
            printResult(result);
        }


    }

    static void printResult(Deque<Integer> result) {
        System.out.println(result.size());

        while (!result.isEmpty()) {
            System.out.print(result.poll());
            System.out.print(" ");
        }
    }

}