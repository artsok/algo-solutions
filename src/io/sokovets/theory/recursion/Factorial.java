package io.sokovets.theory.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(new Factorial().factorial(4));
    }

    int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
