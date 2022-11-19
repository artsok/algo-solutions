package io.sokovets.theory.number_systems;

public class FromBinaryToInteger {
    public static void main(String[] args) {

        //1. Чтобы перевести строчку (бинарную строку) в 10-ую систему можно использовать
        int foo = Integer.parseInt("00111001011110000010100101000000", 2);

        //2. Использовать формулу
        String binaryString = "10111111111111111111111111111111";
        double convertedDouble = 0;

        for (int i = 0; i < binaryString.length(); i++) {

            if (binaryString.charAt(i) == '1') {
                int len = binaryString.length() - 1 - i;
                convertedDouble += Math.pow(2, len);
            }
        }

        int convertedInt = (int) convertedDouble;
        System.out.println(convertedInt);

    }

    public int mySolution(String binary) {
        char[] chars = binary.toCharArray();

        //100 = 2^1+2^0
        int result = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int a = chars[i] - '0';
            int len = chars.length - 1 - i;
            result += a * Math.pow(2, len);
        }
        return result;
    }

    public Integer binaryToInteger(String binary) {
        char[] numbers = binary.toCharArray();
        Integer result = 0;
        int count = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '1') {
                result += (int) Math.pow(2, count);
            }
            count++;
        }
        return result;
    }
}
