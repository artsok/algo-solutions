package io.sokovets.leetcode.easy.easy;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimeToBuyAndSellStock121 {


    public static void main(String[] args) {
        int[] stock = {1, 2, 3, 4, 5};
        int[] stock1 = {10, 9, 8, 7};
        System.out.println(new BestTimeToBuyAndSellStock121().maxProfit(stock));
        System.out.println(new BestTimeToBuyAndSellStock121().maxProfit(stock1));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0; //Завели переменную, которую будем вычислять на каждом шаге.
        int lowestStock = Integer.MAX_VALUE; //Завели переменную, которая отображает самую минимальную цену акции (стока)

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < lowestStock) { //Проверяем, что текущая цена ниже, чем заданный наш lowestStock
                lowestStock = prices[i]; //Если нашли цену акции, которая ниже, чем была то записываем ее как самую низкую
            }

            int currentProfit = prices[i] - lowestStock; //Вычисляем, профит, текущей цены и самой низкой цены которую встречали
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }

    public int maxProfitWithDP(int[] prices) {
        int result = 0;
        int dp[] = new int[prices.length + 1];
        dp[0] = prices[0];

        for (int i = 0; i < prices.length; i++) {
            //[7,1,5,3,6,4] - Какой профит я получу, когда я продам i
            //^      //от 6 -x, и должен быть минимальный
            //dp[x] = MinPrice   //Лучшее цена по которой лучше купить. MinePrice

            int sell = prices[i];
            result = Math.max(result, sell - dp[i]); //dp[i] – лучшая цена

            dp[i + 1] = Math.min(prices[i], dp[i]);//положим значение на следующем шаге. Если знаем предудыщее лучшее значение по которой нам надо купить, то для след.шага обновиим

        }
        return result;
    }

    public int bruteForce(int[] prices) {

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int benefit = prices[j] - prices[i]; //
                result = Math.max(benefit, result);
            }
        }
        return result;
    }
}
