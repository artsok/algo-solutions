package io.sokovets.leetcode.easy.easy;

import java.util.HashSet;
import java.util.Stack;

public class CountBinarySubstrings696 {

    //We need to find number of groups
    //We need to find the sub strings that each of the group is forming
    //Then add all those counts to the main counter

    public static void main(String[] args) {
        //System.out.println(new CountBinarySubstrings696().countBinarySubstrings("000111"));
        //System.out.println(new CountBinarySubstrings696().countBinarySubstrings("001011")); //Expected 6, I have 7
        //System.out.println(new CountBinarySubstrings696().countBinarySubstrings("00110011"));
        //System.out.println(new CountBinarySubstrings696().countBinarySubstrings("10101"));
    }




    public int countBinarySubstrings(String s) {
        int count = 0;
        int index = 1;

        //Точки откуда начинаем
        int prev = 0;
        int curr = 1;

        while (index < s.length()) {

            //Берем пред.элемент и текущий. Если они не равны
            if (s.charAt(index - 1) != s.charAt(index)) {
                count += Math.min(prev, curr); //
                prev = curr;
                curr = 1;
            } else {
                curr++;
            }
            index++;
        }
        count += Math.min(prev, curr);

        return count;
    }


    //00110011
    //1.0011, 01
    //2.01
    //3.
    //"0011", "01", "1100", "10", "0011", and "01".

    public int countBinarySubstringsMySolution(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length;
        int count = 0;

        while (right > left) {
            count += helper(left, right - 1, chars);
            left++;
            //right--;
        }
        return count;
    }

    private int helper(int left, int right, char[] chars) {
        Stack<Character> stack = new Stack<>();

        int count = 0;
        boolean interruptedFlag = false;

        //как-то сыграть на стэке?
        do {
            if (stack.isEmpty()) {
                stack.push(chars[left]);
                left++;
                continue;
            }


            if (chars[left] == stack.peek()) {
                if (interruptedFlag) {
                    break;
                }
                stack.push(chars[left]);
            } else {
                stack.pop();
                interruptedFlag = true;
                count++;
            }

            left++;
        }
        while (!stack.isEmpty() && right >= left);

        if (count > 0 && stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
