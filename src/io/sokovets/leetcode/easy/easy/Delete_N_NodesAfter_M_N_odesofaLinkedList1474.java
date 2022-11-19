package io.sokovets.leetcode.easy.easy;


public class Delete_N_NodesAfter_M_N_odesofaLinkedList1474 {


    public static void main(String[] args) {
        //Первое определение Node это означает последняя запись
        ListNode l1 = new ListNode(10);
        ListNode l2 = new ListNode(9, l1);
        ListNode l3 = new ListNode(8, l2);
        ListNode l4 = new ListNode(7, l3);
        ListNode l5 = new ListNode(6, l4);
        ListNode l6 = new ListNode(5, l5);
        ListNode l7 = new ListNode(4, l6);
        ListNode l8 = new ListNode(3, l7);
        ListNode l9 = new ListNode(2, l8);
        ListNode l10 = new ListNode(1, l9);
        new Delete_N_NodesAfter_M_N_odesofaLinkedList1474().deleteNodes(l10, 5, 3);
    }

    //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
    //_              _              _                  (_ - означает выбираем)

    public ListNode deleteNodes(ListNode head, int m, int n) {

        ListNode curr = head;
        ListNode savePosition = null;

        while (curr != null) {


            for (int i = 1; i < m; i++) { //Убираю из условия больше или равно, так как нам нужно остановиться на текущем, а в if будем делать переход
                if (curr != null) {
                    curr = curr.next;
                    savePosition = curr;
                }
            }

            //savePosition.next = null; //Перизатирает последующие curr (листья)

            for (int i = 1; i <= n; i++) {
                if (curr != null) {
                    //System.out.println(curr.val);
                    curr = curr.next;
                }

            }

            if (curr != null) {
                savePosition.next = curr.next;
                curr = curr.next;
            } else {
                if (savePosition != null) {
                    savePosition.next = null;
                }

            }
        }

        return head;
    }


}
