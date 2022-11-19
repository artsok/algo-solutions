package io.sokovets.timecomplexity;

public class IfLoop {

    //O(N/2) + O(N) = O(N)
//    public static void main(String[] args) {
//        int N = 10;
//        int count = 0;
//        for (int i = N; i > 0; i /= 2) {
//            System.out.println("outer for: " + i);
//            for (int j = 0; j < i; j++) {
//                System.out.println("inner for: " + j);
//                count += 1;
//            }
//        }
//    }

    public static void main(String[] args) {
        int n = 10;
        int i, j, k = 0;
        for (i = n/2; i <= n; i++) { //Этот внешний for выполняется половину ко-во раз от всего числа входящих чисел
            System.out.println("outer for: " + i);
            for (j = 2; j <= n; j = j * 2) { //внутренний цикл выполняется с с O(logN), так как идут с прогрессом умножения на 2. 2 4 8 16, геометрическая прогрессия
                System.out.println("inner for: " + j);
                k = k + n/2;
            }
        }
    }
}
