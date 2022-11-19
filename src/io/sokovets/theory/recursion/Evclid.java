package io.sokovets.theory.recursion;


//Найти наибольший общий делитель
public class Evclid {

    public static void main(String[] args) {
        System.out.println(new Evclid().gcd(13, 28));
    }

    //grand common divisor
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
