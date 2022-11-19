package io.sokovets.leetcode.easy.easy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(4); //Конец (Tail)
        ListNode l6 = new ListNode(2, l5);
        ListNode l7 = new ListNode(3, l6);
        ListNode l8 = new ListNode(3, l7);
        ListNode l9 = new ListNode(2, l8);
        ListNode l10 = new ListNode(1, l9); //Head

        System.out.println(new PalindromeLinkedList().isPalindrome(l10));
    }

    public ListNode reverse(ListNode head) {
        //Как только доходим до конца, возвращаем текущий элемент.
        //Либо есть head null, то сразу возвращаем null;
        if (head == null || head.next == null) {
            return head;
        }

        //Рекурсивно вызываем функцию
        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode curr = head;
        ListNode revereList = reverse(head);

//        while (revereList != null && head != null) {
//            if (curr.val != head.val) {
//                return false;
//            }
//
//            revereList = revereList.next;
//            head = head.next;
//        }

        return true;
    }


    //Copy from LeetCode
    public boolean isPalindromeLP(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
