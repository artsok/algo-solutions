package io.sokovets.hackerrank;

public class ReverseOrder {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 4, 5, 6};
        int aux = 0;

        for(int i = 0; i < a.length/2; i++) {
            System.out.println(i);
            aux = a[a.length - i - 1];
            a[a.length - i - 1] = a[i];
            a[i] = aux;
        }
    }

}
