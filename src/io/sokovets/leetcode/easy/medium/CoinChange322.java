package io.sokovets.leetcode.easy.medium;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class CoinChange322 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int total = 11;
        System.out.println(new CoinChange322().coinChange(coins, total));
    }


    public int coinChange(int[] coins, int amount) {

        int size = coins.length - 1;

        //Определяем массив. Каждый индекс это amount, а значение это сколько монет нам потребуется, чтобы получить эту сумму.
        //Знаем, что для индекса 0 у нас будет 0 монет.
        //Далее по контексту задачи под каждый номина
        int dp[] = new int[amount + 1];

        //Заполняем наш массив значениями, чтобы отслеживать, для всех ли amount мы можем вычислить сколько монет нам потребуется. Бывают такие монеты мы получаем, что не сможем их использовать, следовательно в этом случае ячейка dp заполена не будет
        Arrays.fill(dp, dp.length);

        //Знаем что для amount = 0, нам ненужно НИСКОЛЬКО монет.
        dp[0] = 0;

        //Дальше мы идем от 1 и до нужной суммы, которую нужно достичь
        for (int i = 1; i <= amount; i++) {

            //Перебираем все монеты которые у нас доступны
            for (int j = 0; j <= size; j++) {

                //Берем монеты которые не больше текущей суммы, другие нам просто не нужны
                //Проверяем, что мы знаем решение для предыдущей монеты. F(10) = F(8) + 2
                if (i >= coins[j] && dp[i - coins[j]] != dp.length) {

                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]); //Вычисляем сколько кол-во монет потребуется для текущего решения.
                    // Вот например высчитываем для dp[5] = нам нужно взять значение, которое было для суммы ранее
                    // (отнимаем значение монеты и ее считаем, по-этому +1). Берем минимальное значение из всех монет, которые у нас есть
                }
            }
        }

        //Здесь у нас либо есть значение для суммы, либо стоит маркер, когда нам не удалось вычислить и возвращаем -1
        return dp[amount] == dp.length ? -1 : dp[amount];

    }


    //Аля Greedy
    public int coins1(int[] array, int amount) {

        int answer = 0;
        Arrays.sort(array);
        int index = array.length - 1;

        while (amount != 0 && index >= 0) {
            if (amount >= array[index]) {
                amount -= array[index];
                answer++;
            } else {
                index--;
            }
        }

        return amount == 0 ? answer : -1;
    }



}
