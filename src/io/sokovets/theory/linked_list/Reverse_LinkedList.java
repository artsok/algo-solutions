package io.sokovets.theory.linked_list;


public class Reverse_LinkedList {

    private static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }

        Node() {
        }

        Node(int x, Node next) {
            this.val = x;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Node l1 = new Node(4);
        Node l2 = new Node(3, l1);
        Node l3 = new Node(2, l2);
        Node l4 = new Node(1, l3);
        new Reverse_LinkedList().reverseLinkedList(l4);
    }

    public Node reverse(Node head) {
        // Если head равен нуля либо следующий элемент равен null то вернуть просто head
        if (head == null || head.next == null) {
            return head;
        }

        //Рекурсивный обход. Идем до последнего элемента.
        Node newHead = reverse(head.next);


        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public Node reverseLinkedList(Node head) {

        Node curr = head;

        Node temp = null;

        while (curr != null) {

            if (temp != null) {
                temp = new Node (curr.val, temp);
            } else {
                temp = new Node(curr.val);
            }

            curr = curr.next;
        }

        return temp;
    }

}
