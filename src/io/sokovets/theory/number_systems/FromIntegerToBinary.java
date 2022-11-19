package io.sokovets.theory.number_systems;

public class FromIntegerToBinary {

    public static void main(String[] args) {
        System.out.println(new FromIntegerToBinary().convert(7));
    }

    public String convert(int n) {

        StringBuilder sb = new StringBuilder();


        while (n != 0) {
            sb.append(n % 2);
            n = n / 2;
        }

        return sb.reverse().toString();
    }
}
