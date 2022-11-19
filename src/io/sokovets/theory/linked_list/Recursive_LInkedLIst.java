package io.sokovets.theory.linked_list;


import io.sokovets.theory.linked_list.LinkedList_Add.Node;

public class Recursive_LInkedLIst {


    public static void main(String[] args) {
        //System.out.println(Math.asin(0.5));
        char a = 'b';
        System.out.println("abc".substring(1,1));

        for (int i = 1; i <= 6; i++) {
            for (int j = 6; j >= 1; j--)
                System.out.print(j <= i ? j + " " : " " + " ");
                System.out.println();
        }

    }

    /**
     * Рекурсивный обход списка. Передаем голову
     * @param head
     */
    void printLinkedList(Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.val);
        printLinkedList(head.next);
    }

    //Печатает с последнего элемента к первому
    void printLinkedListFromBackToFirst(Node head) {
        if (head == null) {
            return;
        }

        printLinkedList(head.next);
        System.out.println(head.val);
    }


    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
