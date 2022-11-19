package io.sokovets.leetcode.easy.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck1710 {

    public static void main(String[] args) {
        int[][] temp = {{2, 1}, {4, 4}, {3, 1}};
        int sizeTrack = 5;
        System.out.println(new MaximumUnitsOnATruck1710().maximumUnitsMySolution(temp, sizeTrack));
    }

    public int maximumUnitsLeetCode(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1] - a[1]); //Отсортировали по возврастанию
        queue.addAll(Arrays.asList(boxTypes)); //Добавили все значения которые есть с кол-вом коробок и кол-вом юнитов в каждом

        int unitCount = 0; //Наш ответ

        while (!queue.isEmpty()) { //Идем пока не пустая очерель

            int[] top = queue.poll(); //Достали самый выгодный для нас

            int boxCount = Math.min(truckSize, top[0]); //Кол-во коробок высчитываем как минимальное между нашим размером и коробками которые есть. Коробки которые есть отсортировали по возврастанию с элементами

            unitCount += boxCount * top[1]; //И берем значение и умножаем на кол-во юнитов

            truckSize -= boxCount; //отняли от нашего возможного грузка кол-во коробок которые загрузили

            if(truckSize == 0) //Как стал размер 0, коробоко больше загружать не можем выходим
                break;
        }
        return unitCount;
    }


    public int maximumUnitsMySolution(int[][] boxTypes, int truckSize) {
        //1. Sort by units from big to small size of units
        //2. Get from top elements and incriment boxes.
        //2.Check size. It should be less than truckSize
        //3. return maximum total number of units

        //TimeComplexity = O(LogN+N)
        //SpaceComplexity = O(N)

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int[] box : boxTypes) {
            pq.add(box);
        }


        int currentSize = 0;
        int asnwer = 0;

        while (currentSize < truckSize && pq.size() != 0) {
            int[] current = pq.poll();
            currentSize += current[0];
            System.out.println(currentSize);

            //Но у нас может быть когда вес одной коробки больше, и нам выгодно взять другую которая идет следующая
            if (currentSize > truckSize) {
                currentSize -= current[0];

                //Остаток, сколько надо заполнить
                //int leftSize = truckSize - currentSize;

                int countBoxes = current[0];

                while (countBoxes != 0 && currentSize < truckSize) {
                    asnwer += current[1]; //Имеем ввиду, что просто прибавляем одну коробку и кол-во юнитов в ней
                    currentSize++; //увеличиваем общий размер
                    countBoxes--; //Уменьшаем кол-во коробок
                }

                //Случай когда мы должны пытаться выйти на меньше кол-во truckSize. Если мы выходим за рамки то перейти к след.элементу

                continue; //пропускаем коробку которая не подошла по размерам и пытаемся найти дальше нужную коробку с нужным весом
            }
            asnwer += current[0] * current[1];
        }

        return asnwer;

    }
}
