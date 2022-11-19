package io.sokovets.yandex;

import java.util.Arrays;

/**
 * Красотой массива назовем наибольшее количество подряд идущих в нем четных чисел.
 * Дан массив
 * a
 * , состоящий из
 * n
 * целых чисел. Разрешается не более
 * k
 * раз выбрать любые два элемента этого массива и поменять их местами.
 * Найдите наибольшую возможную красоту массива после применения указанных операций.
 */
public class Krasota {

    public static void main(String[] args) {


        int[] a = {0, 2, 1, -1, -2, 4};
        System.out.println(Arrays.toString(new Krasota().bubbleSort(a, 2)));
    }

    // -1 2 4 3 0
    //[-1,0,2,3,4]

    int[] bubbleSort(int arr[], int k) {

        int count = 0;

        for (int left = 0; left < arr.length; left++) {
            int minInd = left;
            for (int i = left; i < arr.length; i++) {
                if (arr[i] < arr[minInd]) {
                    minInd = i;
                }
            }
            if (count >= k) {
                return arr;
            }
            swap(arr, left, minInd);
            count++;
        }
        return arr;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
