package io.sokovets.leetcode.easy.easy;

import java.util.Stack;


/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * <p>
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * <p>
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively.
 * You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * <p>
 * <p>
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * <p>
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        obj.push(5);
        int param_3 = obj.pop();
        int param_4 = obj.pop();
        int param_5 = obj.pop();
        int param_6 = obj.pop();

        System.out.println("param_2 = " + param_2);
        System.out.println("param_3 = " + param_3);
        System.out.println("param_4 = " + param_4);
        System.out.println("param_5 = " + param_5);
    }
}


class MyQueue {

    final Stack<Integer> LIFO;
    final Stack<Integer> FIFO;
    int lastSize;


    //push - push to top
    //pop - get from top and delete it
    //peek - return from the top

    public MyQueue() {
        this.LIFO = new Stack<>();
        this.FIFO = new Stack<>();
        this.lastSize = 0;
    }



    //push 1
    //push 2
    //pop //[2, 1, ] -> [2]
    //push 3 [2, 3]
    //peek

    public void push(int x) {
        LIFO.push(x); //1, 2, 3, 4. Во главе стека будет находиться 4 - ка.
    }

    //Мы пополняем FIFO когда она пустая. Работаем с ней пока там есть элементы
    public int pop() {
        if (FIFO.isEmpty()) { //Если у нас пустая FIFO
            while (!LIFO.isEmpty()) { //То пока LIFO не пустая, заполняем
                FIFO.push(LIFO.pop()); //4, 3, 2, 1. Берем элемент из головы LIFO и кладем в FIFO.
            }
        }
        return FIFO.pop();
    }


    public int peek() {
        if (FIFO.isEmpty()) {
            while (!LIFO.isEmpty()) {
                FIFO.push(LIFO.pop());
            }
        }

        return FIFO.peek();
    }

    public boolean empty() {
        return FIFO.isEmpty() && LIFO.isEmpty();
    }
}

