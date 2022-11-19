package io.sokovets.leetcode.easy.easy;


/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists21 {


    public ListNode mergeTwoListsCopyFromLeetCode(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //list1 = [1], list2 = [2,5,6], l3 = [1,2,2,4,5,6]

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode curr3 = null;

        ListNode list3 = null;

        //Идем пока оба указателя не будут равны false.
        while (curr1 != null || curr2 != null) {


            //Проверяем, если первый LinkedList у нас пустой
            if (curr1 == null) {

                //Проверяем, если наш list3 пустой, вообще не использовался, то нужно создать первый элемент
                if (curr3 == null) {
                    curr3 = new ListNode(curr2.val);
                    list3 = curr3;

                //Проверяем, если наш list3 не пустой (там есть элемент), то нам нужно присвоить ссылки на следующий элемент значение новое
                } else {
                    ListNode temp = new ListNode(curr2.val);
                    curr3.next = temp;
                    curr3 = curr3.next;
                }

                //Двигаем указатель второго LinkedList
                curr2 = curr2.next;

                //Крутим цикл while дальше
                continue;

            //Проверяем, если второй LinkedList у нас пустой
            } else if (curr2 == null) {
                if (curr3 == null) {
                    curr3 = new ListNode(curr1.val);
                    list3 = curr3;
                } else {
                    ListNode temp = new ListNode(curr1.val);
                    curr3.next = temp;
                    curr3 = curr3.next;
                }

                //Двигаем указатель первого LinkedList
                curr1 = curr1.next;
                continue;
            }


            //Разбираем случай, когда у нас два LinkedList не пустые.
            //Смотрим, если у LinkedList первого значение больше чем у второго
            if (curr1.val > curr2.val) {

                //Проверяем, если наш list3 пустой, вообще не использовался, то нужно создать первый элемент
                if (curr3 == null) {
                    curr3 = new ListNode(curr2.val);
                    list3 = curr3;

                //Если уже использовался
                } else {
                    ListNode temp = new ListNode(curr2.val);
                    curr3.next = temp;
                    curr3 = curr3.next;
                }

                //Идем на следующий указатель
                curr2 = curr2.next;

            } else {

                if (curr3 == null) {
                    curr3 = new ListNode(curr1.val);
                    list3 = curr3;
                } else {
                    ListNode temp = new ListNode(curr1.val);
                    curr3.next = temp;
                    curr3 = curr3.next;
                }

                curr1 = curr1.next;
            }
        }

        //Возвращаем ссылку на первый элемент
        return list3;
    }
}
