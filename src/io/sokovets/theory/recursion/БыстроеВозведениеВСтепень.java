package io.sokovets.theory.recursion;

//Алгоритм быстрого возведения в степень
public class БыстроеВозведениеВСтепень {

    public static void main(String[] args) {
        System.out.println(new БыстроеВозведениеВСтепень().fastPower(2, 10));
    }

    double fastPower(double a, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 1) {
            return a * fastPower(a, n - 1);
        } else {
            //Для четной степени
            return fastPower(a * a, n / 2);
        }
    }
}
