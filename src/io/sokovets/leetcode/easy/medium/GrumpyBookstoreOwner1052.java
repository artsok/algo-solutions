package io.sokovets.leetcode.easy.medium;

/**
 * There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
 * <p>
 * On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
 * <p>
 * When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
 * <p>
 * The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
 * <p>
 * Return the maximum number of customers that can be satisfied throughout the day.
 * <p>
 * Example 1:
 * <p>
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * Example 2:
 * <p>
 * Input: customers = [1], grumpy = [0], minutes = 1
 * Output: 1
 */
public class GrumpyBookstoreOwner1052 {

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        //System.out.println(new GrumpyBookstoreOwner1052().maxSatisfiedLTSolution(customers, grumpy, minutes));
        System.out.println(new GrumpyBookstoreOwner1052().maxSatisfiedTTl(customers, grumpy, minutes));
    }





    //TimeComplexity = O(N^2)
    //SpaceComplexity = O(1)
    public int maxSatisfiedTTl(int[] customers, int[] grumpy, int minutes) {
        int maxNumberOfCustomers = 0;

        //Объявили два вложенных циклв в котором будем двигать окно. Окно у нас minutes
        for (int i = 0; i < grumpy.length; i++) {
            int currentMaxNumberOfCustomers = 0;

            for (int j = 0; j < grumpy.length; j++) {
                if (i + minutes > j && j >= i) { //Проверяем наше окно. Если j входит в диапозон окна и
                    // когда j >= i то мы понимаем что еще в окне и все что в окне складываем,
                    // так как продавец применяет хитрость. Он может не материться в определенное кол-во minutes
                    currentMaxNumberOfCustomers += customers[j];
                    continue;
                }
                if (grumpy[j] == 0) { //Суммируем показатель счастливых покупателей когда не ругается продавец
                    currentMaxNumberOfCustomers += customers[j];
                }
            }

            System.out.println(currentMaxNumberOfCustomers);

            maxNumberOfCustomers = Math.max(maxNumberOfCustomers, currentMaxNumberOfCustomers);

        }
        return maxNumberOfCustomers;
    }


    public int maxSatisfiedLTSolution(int[] customers, int[] grumpy, int minutes) {
        var n = customers.length;

        var max = 0;
        var start = 0;

        //Если начала больше или равно
        while (start <= n - minutes) {
            var sum = 0;
            var end = start + minutes;

            for (int i = 0; i < start; i++) {
                if (grumpy[i] == 0) {
                    sum = sum + customers[i];
                }
                //sum = grumpy[i] == 0 ? sum + customers[i] : sum;
            }

            //Получается все суммируем то что входит в диапозон хитрости продовца. Он справляется со своим стрессом.
            for (int i = start; i < end; i++) {
                sum += customers[i];
            }

            for (int i = end; i < customers.length; i++) {
                if (grumpy[i] == 0) {
                    sum = sum + customers[i];
                }

                //sum = grumpy[i] == 0 ? sum + customers[i] : sum;
            }

            System.out.println(sum);

            max = Math.max(max, sum);
            start++;
        }

        return max;
    }
}

/**
 * 1  2  3  4  5  6  7  8
 * //[1, 0, 1, 2, 1, 1, 7, 5]
 * [1] x -> Прошла одна минута, покинули магазин
 * [0] -> Зашло 0 новых, общее число посетителей 0
 * [1] -> Зашел один посетитель на 3 минуты. Он должен выйти на 6 минуте
 * [2, 2] -> Зашли 2 новых посетителя на 4 минуты. Должны выйти на 8. Итого 3 посетителя
 * [1] -> Зашел 1 посетитель на 1 минуту. Должен выйти на 10 минуте. Итого 4 посетителя
 * [1]--> Зашел 1 посетитель на 1 минуту. Должен выйти на 12 минуте. Один вышел который заходил на 3 минуте. Итого 3 посетителя
 * [7]-----------> Зашли 7 посетителей на 7 минут. Должны выйти на 14 минуте. В итоге 10 посетителей
 * [5] -------> Зашли 5 посетителей на 8 минут минут. Вышли 2-ое. Итого 13 посетителей сейчас
 * //[0,1,0,1,0,1,0,1]
 * <p>
 * <p>
 * [1, 0, 1, 2, 1, 1, 7, 5]
 * <p>
 * 1  2  3  4  5  6  7  8
 * <p>
 * [0, 1, 0, 1, 0, 1, 0, 1]
 * <p>
 * //Двигаем окно, окно у нас может меняться. Оно задано как minutes через параметр метода
 * [0, 1, 0] Х  Х  Х  Х  Х
 * Х [1, 0, 1] Х  Х  Х  Х
 * Х  Х [0, 1, 0] Х  Х  Х
 * Х  Х  Х [1, 0, 1] Х  Х
 * Х  Х  Х  Х [0, 1, 0] Х
 * Х  Х  Х  Х  Х [1, 0, 1]
 * <p>
 * 1  0  1  - 1 1 7 5
 * 0  Х  0  Х 0 Х Х Х
 * <p>
 * 1, 0, 1, 2, 1, 1, 7, 5
 * X  X  X
 **/