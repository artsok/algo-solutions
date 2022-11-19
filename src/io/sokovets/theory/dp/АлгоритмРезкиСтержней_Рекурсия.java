package io.sokovets.theory.dp;


/**
 * Давайте начнем с чего-нибудь простого:
 *
 * Задан стержень длиной n и массив, содержащий цены на все детали размером меньше n .
 *
 * Определите максимальную стоимость, которую можно получить, разрезав стержень и продав его по частям.
 */
public class АлгоритмРезкиСтержней_Рекурсия {



    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length;

        System.out.println("Max rod value: " + getValue(values, rodLength));
    }

    static int getValue1(int[] values, int length) {
        if (length <= 0)
            return 0;
        int tmpMax = -1;
        for (int i = 0; i < length; i++) {
            tmpMax = Math.max(tmpMax, values[i] + getValue(values, length - i - 1));
        }
        return tmpMax;
    }

    static int getValue(int[] value, int rodLength) {
        int[] dp = new int[rodLength + 1];



        return 0;
    }

    /*
     static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            for (int j = 0; j < i; j++)
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            subSolutions[i] = tmpMax;
        }
        return subSolutions[rodLength];
    }
     */
}
