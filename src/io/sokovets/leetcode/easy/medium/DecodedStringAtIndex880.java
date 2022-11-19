package io.sokovets.leetcode.easy.medium;


import java.util.Stack;

/**
 * You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
 * Given an integer k, return the kth letter (1-indexed) in the decoded string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leet2code3", k = 10
 * Output: "o"
 * Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * Example 2:
 * <p>
 * Input: s = "ha22", k = 5
 * Output: "h"
 * Explanation: The decoded string is "hahahaha".
 * The 5th letter is "h".
 * Example 3:
 * <p>
 * Input: s = "a2345678999999999999999", k = 1
 * Output: "a"
 * Explanation: The decoded string is "a" repeated 8301530446056247680 times.
 * The 1st letter is "a".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 100
 * s consists of lowercase English letters and digits 2 through 9.
 * s starts with a letter.
 * 1 <= k <= 109
 * It is guaranteed that k is less than or equal to the length of the decoded string.
 * The decoded string is guaranteed to have less than 263 letters.
 */
public class DecodedStringAtIndex880 {


    public static void main(String[] args) {
        DecodedStringAtIndex880 decodedStringAtIndex880 = new DecodedStringAtIndex880();
        System.out.println(decodedStringAtIndex880.decodeAtIndexWithStack("leet2code3", 30));
    }


    public String decodeAtIndexWithStack(String str, int k) {
        Stack<String> stack = new Stack<>();
        int l = 0;
        int i = 0;
        char[] chars = str.toCharArray();

        while(i < str.length() && l < k) { //Смотрим, чтобы общая длинна l была не больше k, смысл считать по полной нам нет
            if (Character.isAlphabetic(chars[i])) {
                stack.push(chars[i] + "_" + l++);
            } else {
                //Если число у нас попалось, то преобразуем его к int
                int temp = chars[i] - '0';
                l = l * temp; //Считаем общую длинну
            }
            i++;
        }

        //Теперь она хочет достать последний элемент и получить позицию
        int position = Integer.parseInt(stack.peek().substring(2));

        while (k != position && k != 0) {
            while (k < position) {
                stack.pop();
                position = Integer.parseInt(stack.peek().substring(2));
            }
            k = k % position;
        }

        return stack.peek().substring(0, 1);
    }


    public String decodeAtIndex(String str, int k) {

        long size = 0;

        //1. Текущий пункт, мы посчитаем длину всей строки в случае декодирования. Будет длина определенная.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); //Берем символ
            if (Character.isDigit(ch)) { //смотрим если число
                size *= ch - '0'; //то увеличиваем число на текущий размер
            } else {
                size++; //если символ то увеличиваем наш размер
            }
        }

        //Далее идем с конца строки до 0. Смотри взяли последний элемент с конца и если там число, то делим полученную длину size на число temp которое прочитали.
        for (int i = str.length() - 1; i >= 0; --i) {
            char c = str.charAt(i); //берем символ с конца >> leet2code3

            if (Character.isDigit(c)) { //Если число
                int temp = c - '0'; //преобразуем к int и берем нащ size и делим.
                size  = size / temp;
                k = (int) (k % size); //k %= size; вот здесь длина к примеру k = 10  а size остаток 12
            } else { //Если не число
                if (k == 0 || k == size) {
                    return Character.toString(c);
                }
                size--; //уменьшаем наш size
            }

        }
        return "";
    }


    public String decodeAtIndexTTL(String s, int k) {
        /**
         1. introduce StringBuilder, introduce 2 pointers
         leet2code3

         ^

         leet - указатель куда вставлять
         ^
         2. iterate through all characters in string s
         3. add character to stringbuilder
         4. if character == digits, get string from stringbuilder and add all character to sb (k times as digit)
         5. stop when k would be greater than size of sb

         TimeComplexity - K*O(N)?
         SpaceComplexity = O(N)
         **/

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int l = 0;

        //Идем пока l не дойдет до конца строки
        while (l < chars.length) {

            //Проверяем является ли символом
            if (Character.isAlphabetic(chars[l])) {
                sb.append(chars[l++]); //если является добавляем в SB и увеличиваем указатель l++
            } else {
                String temp = sb.toString(); //Все что насобирали в sb трансформируем в temp
                int count = chars[l] - '0'; //преобразуем из char в int

                for (int i = 0; i < count - 1; i++) { //Цикл повторений, сколько раз мы должны вставить
                    sb.append(temp); //Добавляем слово

                    if (sb.length() > k) { //Чекаем что размер должен быть меньше К
                        break;
                    }
                }

                //Опять чекам, чтобы не вычислять всю строку
                if (sb.length() > k) {
                    break;
                }

                //Увеличиваем индекс l
                l++;
            }
        }

        //Преобразуем в стркоу
        return "" + sb.charAt(k - 1);
    }

}
