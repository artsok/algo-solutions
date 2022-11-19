package io.sokovets.leetcode.easy.easy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses20 {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {

        Stack<Character> queue = new Stack<>();
        // if (s.length()%2 != 0) { //Если у нас приходит нечетное кол-во символов, то сразу false;
        //     return false;
        // }


        for (char ch : s.toCharArray()) { //идем по каждому символу
            if (ch == '(' || ch == '{' || ch == '[') {
                queue.push(ch);
                continue;
            }
            if (ch == ')' || ch == '}' || ch == ']') {
                if (!queue.isEmpty()) {
                    if (queue.peek() == '{' && ch == '}') {
                        queue.pop();
                    } else if (queue.peek() == '[' && ch == ']') {
                        queue.pop();
                    } else if (queue.peek() == '(' && ch == ')') {
                        queue.pop();
                    } else {
                        queue.push(ch);
                    }

                } else {
                    return false;
                }
            }

        }

        return queue.isEmpty();
    }
}
