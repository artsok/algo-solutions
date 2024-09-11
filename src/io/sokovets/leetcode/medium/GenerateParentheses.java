package io.sokovets.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


/**
 * Example 1:
 * <p>
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"] Example 2:
 * <p>
 * Input: n = 1 Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {

    //()
    //((()))

    //1. Сгенерить все возможные варианты
    //2. Посмотреть которые валидные
    //3. Вывести которые валидные

    //We have two types of parentheses.
    //1. ( and )

    char[] parentheses = "()".toCharArray();

    int maxStringLength = 2 * n;

    List<String> generatedData = generate("", parentheses, maxStringLength);
    System.out.println(generatedData);

    Set<String> result = new HashSet();

    //Validation
    for (String value : generatedData) {
      if (value.length() == maxStringLength && isValid(value)) {
        System.out.println(value);
        result.add(value);
      }
    }

    return new LinkedList<>(result);
  }

  // We should check the size, if 0 it's valid, stack is not empty it's invalid.
  private boolean isValid(String data) {

    if (data.length() % 2 != 0) {
      return false;
    }

    char[] chars = data.toCharArray();

    if (chars[0] == ')') {
      return false;
    }

    Stack<Character> stack = new Stack<>();

    for (char aChar : chars) {

      if (aChar == '(') {
        stack.push(aChar);
      }

      if (aChar == ')') {
        if (stack.size() != 0 && stack.peek() == '(' && aChar == ')') {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    return stack.size() == 0;
  }

  private List<String> generate(String currentCombination, char[] parentheses, int n) {

    List<String> result = new ArrayList<>();

    if (currentCombination.length() == n) {
      result.add(currentCombination);
      return result;
    }

    for (char c : parentheses) {
      result.add(currentCombination + c);
      result.addAll(generate(currentCombination + c, parentheses, n));
    }
    return result;
  }

}
