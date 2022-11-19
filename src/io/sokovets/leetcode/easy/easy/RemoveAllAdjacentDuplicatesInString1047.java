package io.sokovets.leetcode.easy.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString1047 {
    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString1047().removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}

