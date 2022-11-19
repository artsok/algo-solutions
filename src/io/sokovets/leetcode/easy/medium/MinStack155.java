package io.sokovets.leetcode.easy.medium;

import java.util.Map;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class MinStack155 {

    //Для этой ошибки, надо обновлять minValue на Integer.Max_Value, так как сохроняется старые значения.
    //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
    //        [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

    //Output - [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
    //Exptected - [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
    //2147483647 -> 2147483647


    /*
    ["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
            [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]

    Output:
            [null,null,null,-10,-10,null,-20,-20,-20,-20,null,null,null,-20,null,null,-7,-20,null]
    Expected:
            [null,null,null,-10,-10,null,-20,-20,-20,-20,null,null,null,-10,null,null,-7,-10,null]
     */

    public static void main(String[] args) {
        MinStack155 minStack155 = new MinStack155();
        minStack155.push(-2);
        minStack155.push(0);
        minStack155.push(-3);

        System.out.println(minStack155.getMin());
    }

    private Stack<Map.Entry<Integer, Long>> stack;
    private long minValue;

    public MinStack155() {
        this.stack = new Stack<>();
    }

    //Получается кейс, когда достали

    //void push(int val) pushes the element val onto the stack.
    public void push(int val) {

        if (stack.isEmpty()) {
            minValue = Math.min(val, Integer.MAX_VALUE);
        } else {
            minValue = Math.min(val, stack.peek().getValue()); //stack.peek().getValue(); - смотрим min значение на пред.шаге
        }

        Map.Entry<Integer, Long> pair = Map.entry(val, minValue);
        this.stack.push(pair);
    }

    //void pop() removes the element on the top of the stack.
    public void pop() {
        this.stack.pop();
    }

    //int top() gets the top element of the stack.
    public int top() {
        return this.stack.peek().getKey();
    }

    //int getMin() retrieves the minimum element in the stack.
    public int getMin() {
        return Math.toIntExact(this.stack.peek().getValue());
    }
}
