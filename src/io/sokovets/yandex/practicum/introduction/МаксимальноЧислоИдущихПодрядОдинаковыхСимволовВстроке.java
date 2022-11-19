package io.sokovets.yandex.practicum.introduction;

public class МаксимальноЧислоИдущихПодрядОдинаковыхСимволовВстроке {

    public static void main(String[] args) {
        System.out.println(new МаксимальноЧислоИдущихПодрядОдинаковыхСимволовВстроке().max_consecutive_elements("abbcdeaa"));
    }
    int max_consecutive_elements(String str) {
        //aabbcdeaa

        int result = 0;
        int currentIndex = 0;
        while (currentIndex < str.length()) {

            int nextIndex = currentIndex;
            while (nextIndex < str.length() && str.charAt(currentIndex) == str.charAt(nextIndex)) {
                nextIndex++;
            }

            result = Math.max(result, nextIndex - currentIndex);
            currentIndex = nextIndex;
        }

        return result;
    }


}
