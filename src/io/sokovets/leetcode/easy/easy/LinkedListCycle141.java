package io.sokovets.leetcode.easy.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);

        new LinkedListCycle141().hasCycle(l4);
//[3,2,0,-4]
    }

    //TimeComplexity = O(N)
    //SpaceComplexity = O(1)
    public boolean hasCycleLP(ListNode head) {


        if (head == null) {
            return false;
        }

        //Делаем два указателя
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) { //Если у нас четное кол-во узлов и не четное

            fast = fast.next.next; //Взяли на 2 элемента вперед
            slow = slow.next; //взяли на 1 элемент вперед

            if (slow == fast) {
                return true;
            }

        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>(); //Вычисляет хэш объекта. И смотрим если такой добавлен уже, то мы считаем, что цикл идет
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode() {
    }


    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}