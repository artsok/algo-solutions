package io.sokovets.leetcode.easy.easy;

public class PowerOfTwo231 {

    public static void main(String[] args) {
//        System.out.println(new PowerOfTwo231().isPowerOfTwo(4));
//        System.out.println(new PowerOfTwo231().isPowerOfTwo(6));
//        System.out.println(new PowerOfTwo231().isPowerOfTwo(8));
//        System.out.println(new PowerOfTwo231().isPowerOfTwo(16));
//        System.out.println(new PowerOfTwo231().isPowerOfTwo(12));
        System.out.println(new PowerOfTwo231().isPowerOfTwo2(14));
    }

    //O(1), применяем трюк
    public boolean isPowerOfTwo3(int n) {
        if (n == 0) {
            return false;
        }

        long x = (long) n;
        return (x & (-x)) == x; //Что означает эта запись?: берем число х и инвертируем его. Получается -х.
        // Далее с помощтю логического оператора & сравниваем. И если результат равен первоночальному числу то возвращаем true.
    }



    //O(logN)
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        int mask = 1;
        int counts = 0;

        for (int i = 1; i < 32; i++) {
            if ((mask & n) != 0) {
                counts++;
            }
            mask = mask << 1;
        }
        return counts == 1;
    }


    /*
    Задача решена перегоном числа в двоичный формат.
    И далее смотрим, что кол-во битов "1" должен быть равен 1. Если больше, то число не подходит

    Представление 10-ые:
        100  - 4
        10   - 2
        1000 - 8
     */
    public boolean isPowerOfTwo1(int n) {
        long tempNum = n;
        if (n < 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        while (tempNum != 0) {
            sb.append(tempNum % 2);
            tempNum = tempNum / 2;
        }

        sb.reverse();
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }
        }
        return count == 1;
    }
}
