package io.sokovets.theory.permutations;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/?ref=lbp
public class PermutationAllCharacterInStringWithBacktracking {

    public static void main(String[] args) {
        String a = "ABC";
        List<String> list = new ArrayList<>();
        String answer="";
        permute(a, answer, list);
        System.out.println(list);
    }

    static void permute(String str, String answer, List<String> list) {
        if (str.length() == 0) { //Если длина оригинальной подстроки равна 0. В какой-то момент у нас строка str будет равно 0, так как конкатинация строк leftSubStr + rightSubStr ничего не даст.
            list.add(answer); //Добавляем в список
        }

        for (int i = 0; i < str.length(); i++) { //Цикл, который идет от 0 до конца длины строки
            char ch = str.charAt(i);  //Взяли символ из оригинальной строки
            String leftSubStr = str.substring(0, i); //Получили подстроку от 0 до i, всегда может увеличиваться. сначала от {0,1}, {0,2}, {0,3}, {0, 4} и так до N
            String rightSubStr = str.substring(i + 1); //Берем подстроку от индекса который i + 1 и до конца строки. Сначала от {1,N}, {2,N}
            String rest = leftSubStr + rightSubStr;
            permute(rest, answer + ch, list);

        }

    }


}
