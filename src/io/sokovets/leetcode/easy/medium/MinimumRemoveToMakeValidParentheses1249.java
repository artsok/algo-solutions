package io.sokovets.leetcode.easy.medium;

import java.util.*;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * <p>
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 */
public class MinimumRemoveToMakeValidParentheses1249 {
    public static void main(String[] args) {
        System.out.println(new MinimumRemoveToMakeValidParentheses1249().minRemoveToMakeValid("))(("));
    }

    public String minRemoveToMakeValid(String s) {

        //1. Iterate all characters
        //2. Put to Stack index of parantheses [1,3,5]
        //3. To understand which parantheses is valid and which not
        //4. Delete from s index of incorrect index

        int size = s.length();
        Stack<Integer> stack = new Stack<>(); //Скидываем с стэк сначала открывающуюся скобку, дальше если закрывающаяся поподается, то из стека мы забираем методом poll.
        List<Integer> deleted = new ArrayList<>(); //Сюда сохраняем индекс символа который потребуется удалить из строки

        //lee(t(c)o)de)"

        //stack =
        //deleted = 0,1

        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);

            } else if (ch == ')') {
                if (stack.isEmpty()) { //Проверяем, вот для такого случая: '))((', либо сразу когда встречаем первые элемент '('
                    deleted.add(i);
                    continue;
                }
                stack.pop();
            }
        }

        for (Integer index : stack) { //Добавили в список на удаление, то что осталось в стэке без пары
            deleted.add(index);
        }

        //))((
        StringBuilder result = new StringBuilder(s);
        for (int i = deleted.size() -1; i >= 0; i--) {
            result.deleteCharAt(deleted.get(i));
        }


        //0,1,2,3


        return result.toString();
    }


}

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> deleted = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length();i++){
            char ch = s.charAt(i);
            if ( ch =='('){
                stack.push(i);
            } else if (ch ==')'){
                if (stack.isEmpty()){
                    deleted.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        //[((]
        for(int i:stack){
            deleted.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length();i++){
            if (!deleted.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}