package io.sokovets.leetcode.easy.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * <p>
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //2 -> 4 -> 3 -> 9
        //2 -> 5 -> 7
        //2 -> 9 -> 0 -> 0 -> 1

        /**
         0. greate variables, curr1, curr2, extraDigits, newHead
         1. iterate l1 and l2. If null use 0.
         2. make sum of l1 var and l2 var
         3. if (sum > 9), add extraDigits = 1, or just use sum
         4. if (extraDigits == 1), greate new Node and edd
         5. return newHead;

         TimeComplexity = O(N)
         SpaceComplexity = O(N)
         **/

        //Переменная, чтобы понимать есть ли у нас дополнение 10-ки
        int extraDigit = 0;

        //Объявляем новый список
        ListNode l3 = null;

        //Сохраняем первый элемент в списке
        ListNode newHead = null;

        int var1, var2, var3;

        //Идем пока кто-нибудь из l2 и l1 не будет равен null
        while (l1 != null || l2 != null) {

            //Если null то просто подставляем 0
            if (l1 != null) {
                var1 = l1.val;
            } else {
                var1 = 0;
            }

            if (l2 != null) {
                var2 = l2.val;
            } else {
                var2 = 0;
            }

            var3 = var1 + var2;

            //Если у нас l3 не инициализирован, то создаем новую Node. Если проинициализирован, то приравниваем след.элементу новый элемент и двигаем указатель на этот новый элемент
            if (l3 != null) {
                l3.next = new ListNode(var3);
                l3 = l3.next; //Вот здесь двигаем указатель на новый элемент
            } else {
                l3 = new ListNode(var3);
                newHead = l3;
            }

            //Это проверка, если кто-то первым станет null из l1 и l2
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }


        //Приравняли temp голову нашего списка. Первый список хранить полные просуммированные числа не разбитые
        ListNode temp = newHead;
        ListNode lastNode = null;

        //We should check if value in Node more than 9 or not
        while (temp != null) {

            if (extraDigit == 1) {
                temp.val = temp.val + 1;
                extraDigit = 0;
            }

            if (temp.val > 9) {
                temp.val = temp.val % 10;
                extraDigit = 1;
            }

            if (temp.next == null) {
                lastNode = temp;
            }

            temp = temp.next;
        }

        //Если на последнем элементе у нас дополнение 10-ки есть, то добавить нужно новый узел
        if (extraDigit == 1) {
            lastNode.next = new ListNode(1);
        }
        return newHead;
    }

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

}
