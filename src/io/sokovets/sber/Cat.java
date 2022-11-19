package io.sokovets.sber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Необходимо реализовать функцию, которая удалит в строке все повторяющие подряд символы  таким образом,
//чтобы на выходе получилось "Кошка запрыгнула на забор"
public class Cat {
    public static void main(String[] args) {
        String a = "Кккоооошшшкаааа Зззззапрыыыыгнууула нааа зааааабооррр";
        System.out.println("'" + new Cat().removeRepeats(a) + "'");
    }

    private String removeRepeats(String s) {
        String str = s.toLowerCase();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
            if (i > 0 && str.charAt(i-1) == str.charAt(i)) {
                list.set(i -1, null);
                list.set(i, null);
            }
        }


        return "";
    }



    //Одно из решений, чтобы не выйти за рамки массива добавляем к каждому элементы маркер в конец слова.
    //Разбиваем массив на подмассив слов. и проходимся по каждому слову и добавляем его в результат.
//    private String removeRepeats(String s) {
//        String[] splitString = s.toLowerCase().split(" ");
//        StringBuilder result = new StringBuilder();
//
//        for (String str : splitString) {
//
//            char[] chars = str.concat("Х").toCharArray();
//
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[i] == 'Х') {
//                    break;
//                }
//                if (chars[i] != chars[i + 1]) {
//                    result.append(chars[i]);
//                }
//            }
//            result.append(" ");
//        }
//
//        return result.toString().trim();
//    }

    /**
     * Использование HashMap. Идея подсчитать, какие буквы где встречаются. Например символ 'к' встречается в индексе 0,1,2,10.
     * Проверить если есть последовательность символов то промаркеровать, что это повторяющие символы.
     * Далее собрать массив из тех символов, которые не повторяюттся.
     * Увеличить 0-ый символ, сделать большую буквы.
     * Вернуть строку
     *
     * @param s
     * @return
     */
//    private String removeRepeats(String s) {
//        char[] charArray = s.toLowerCase().toCharArray();
//        Map<Character, List<Integer>> map = new LinkedHashMap<>();
//
//        //Сделали соотношение символов и индексов, где символы содержаться
//        for (int i = 0; i < charArray.length; i++) {
//            List<Integer> indexes = new LinkedList<>();
//            indexes.add(i);
//            map.merge(charArray[i], indexes, (v1, v2) -> Stream.of(v1, v2).flatMap(Collection::stream).collect(Collectors.toList()));
//        }
//
//
//        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
//            List<Integer> value = entry.getValue(); //0, 1, 2, 10
//
//            int index = value.get(0);//21
//            //Удалить подряд идущие числа
//            for (int i = 1; i < value.size(); i++) { //'a' -> 0, 1, 2, 6
//                if (index + 1 == value.get(i)) {
//                    index = value.get(i);
//                    value.set(i, Integer.MAX_VALUE);
//                    continue;
//                }
//                index = value.get(i);
//            }
//        }
//
//        char[] result = new char[s.length()];
//
//        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
//            List<Integer> value = entry.getValue();
//            for (Integer a : value) {
//                if (a != Integer.MAX_VALUE) {
//                    result[a] = entry.getKey();
//                }
//            }
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < result.length; i++) {
//            if (i == 0) {
//                result[0] = (char) (result[0] - 32); //Вычитаем дельту в 32, чтобы получить из маленькой буквы большую по ascii.
//            }
//                if (result[i] != '\u0000') {
//                    stringBuilder.append(result[i]);
//                }
//        }
//
//        return stringBuilder.toString();
//
//    }

}
