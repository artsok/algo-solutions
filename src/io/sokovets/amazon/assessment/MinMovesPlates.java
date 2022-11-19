package io.sokovets.amazon.assessment;

import java.util.Collections;

import static java.util.Collections.swap;

/**
 * Imagine you are shopping on [Amazon.com](http://Amazon.com) for some good weight lifting equipment. The equipment you want has plates of many different weights that you can combine to lift. (Представьте, что вы покупаете на [Amazon.com](http://amazon.com/) хорошее оборудование для поднятия тяжестей. Оборудование, которое вам нужно, имеет пластины разного веса, которые вы можете комбинировать для подъема).
 * <p>
 * The listing on Amazon gives you an array, **plates**, that consists of **n** different weighed plates, in kilograms. There are no two plates with the same weight. The element **plates[i]** denotes the weight of the i-th plate from the top of the stack. You consider weight lifting equipment to be good if the plate at the top is the lightest and the plate at the bottom is the heaviest. (Листинг на Amazon дает вам массив **блинов**, состоящий из **n** пластин разного веса в килограммах. Не существует двух тарелок с одинаковым весом. Элемент plate[i] обозначает вес i-й тарелки сверху стопки. Вы считаете, что оборудование для поднятия тяжестей хорошее, если блин вверху самый легкий, а диск внизу самый тяжелый.)
 * <p>
 * More formally, the equipment with array plates will be called good weight lifting equipment  if it satisfies the following conditions (assuming the index of the array start from **1**):
 * <p>
 * plates[1] < plates[i] for all (2 ≤ i ≤ n)
 * <p>
 * plates[i] < plates[n] for all (1 ≤ i ≤ n - 1)
 * <p>
 * Более формально оборудование с массивными пластинами будет называться хорошим оборудованием для поднятия тяжестей, если оно удовлетворяет следующим условиям (при условии, что индекс массива начинается с **1**:
 * <p>
 * пластины[1] < пластины[i] для всех (2 ≤ i ≤ n)
 * <p>
 * пластины[i] < пластины[n] для всех (1 ≤ i ≤ n - 1)
 */
public class MinMovesPlates {

    public static void main(String[] args) {
        System.out.println(new MinMovesPlates().getMinMoves(new int[]{2, 4, 3, 1, 6}));
    }

    //Example: 2, 4, 3, 1, 6
    //First move: swap the third and the fourth plates [2, 4, 1, 3, 6]
    //Second move: swap the second and the third plate [2, 1, 4, 3, 6]
    //Third move: swap the first and the second plate [1, 2, 4, 3, 6]

    //0 1  2 3 4
    //4,11,9,10,12

    //0 1 2 3 4
    //2 4 3 1 6
    //^
    //      ^
    //  ^

    // l = 0, r = 3
    //mid = 1
    //4

    int getMinMoves(int[] plates) {
        int l = 0;
        int r = plates.length - 1;
        int count = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (plates[mid] < plates[r]) {
                r = mid - 1;
            } else if (plates[mid] > plates[l]) {
                l = mid + 1;
            }

            if (plates[mid] == plates[l]) {
                break;
            }

            if (plates[r] < plates[mid]) {
                swap(plates, r, r - 1, count);
            } else if (plates[l] > plates[mid]) {
                swap(plates, l, l - 1, count);
            }
        }
        return count;
    }

    void swap(int[] plates, int r, int l, int count) {
        count++;
        int temp = plates[r];
        plates[r] = plates[l];
        plates[l] = temp;
    }


}
