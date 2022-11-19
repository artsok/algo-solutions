package io.sokovets.theory.sort;

import java.util.Arrays;

public class BubbleSort {

    //Time complexity O(N^2)
    int[] bubbleSort(int arr[]) {
        int size = arr.length;

        //4 1 2 5 8
        //1 4 2 5 8


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] i = {9, 4, 2, 8, 5, 1};
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(i)));
        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(arr)));
    }
}
