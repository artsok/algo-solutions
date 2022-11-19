package io.sokovets.yandex;

import java.util.*;

/**
 * Андрей торгует акциями Яндекса на бирже. Торги длятся
 * N
 * N дней. У Андрея есть информация о стоимости акций Яндекса в каждый из дней торгов.
 * Каждый день торгов, Андрей может продать и/или купить одну акцию. Но в конце каждого дня у Андрея должно остаться не более одной акции.
 * Помоги Андрею определить, сколько он может заработать, если будет продавать и покупать акции Яндекса оптимальным образом.
 */
public class Акции {


    public void rigthAnswer() {
        int[] costs = new int[]{1, 2, 3, 4, 5};
        new Акции().rightSolution(costs);
    }

    //O(N)
    public void rightSolution(int[] prices) {
        int maxProfit = 0; //Наш максимальный профит
        int lowestPrice = Integer.MAX_VALUE; //Самая минимальная стоимость акции. Изначально считаем, что она очень высокая.

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < lowestPrice) { //Пытаемся найти самую низкую цену. Текущая цена меньше, чем lowestPrice, да.
                lowestPrice = prices[i];
            }

            int currentProfit = prices[i] - lowestPrice;

            if (maxProfit < currentProfit) {
                maxProfit = currentProfit;
            }
            System.out.println(maxProfit);
        }
    }


    //Неверное решение
    public static void main(String[] args) {
        //может продать или купить
        //array[1,2,3,4]
        //не более одной акции
        //N - кол-во дни

//        Scanner scan = new Scanner(System.in);
//        List<String> emails = new ArrayList<>();
//
//
//        int N  = scan.nextInt();
//
//
//        while (N != 0) {
//            emails.add(scan.next().trim());
//            N--;
//        }

        int[] costs = new int[]{1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>();
        for (int cost : costs) {
            list.add(cost);
        }
        int max = Collections.max(list); //Max value of order
        int min = Collections.min(list); //Min value of order

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < costs.length; i++) {
            map.put(costs[i], i);
        }

        int indexOfMaxValue = map.get(max);
        int indexOfMinValue = map.get(min);

        if (indexOfMaxValue > indexOfMinValue) {
            System.out.println(max - min);
        } else {
            System.out.println(0);
        }
    }
}
