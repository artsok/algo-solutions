package io.sokovets.leetcode.easy.medium;


/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class SortList148 {

    public static void main(String[] args) {
        //Идем с конца
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(4, l3);

        new SortList148().sortList(l4);
    }


    ListNode merge(ListNode part1, ListNode part2) {
        ListNode preHead = new ListNode();

        //Поставили указатель
        ListNode curr = preHead;

        while (part1 != null && part2 != null) { //Здесь мы идем пока первый из списков не достигнет до null
            //Идет сравнение
            if (part1.val > part2.val) {
                curr.next = part2; //присваиваем элементу наш текущий элемен
                curr = curr.next; //Двигаем указатель на следующий элемент
                part2 = part2.next; //Если у нас пришел список из элеменов, то нужно перейти на следующий
            } else {
                curr.next = part1;
                curr = curr.next;
                part1 = part1.next;
            }
        }

        if (part1 != null) { //Если у нас пришли два списка, но один больше чем другой (Либо один элемент мы обработали, а другой остался). Нужно проверить.
            curr.next = part1;
        }

        if (part2 != null) { //Проверяем, что в другом списке не осталось элементов.
            curr.next = part2;
        }

        return preHead.next; //Возвращаем ссылку на первый элемент
    }


    public ListNode sortList(ListNode head) {

        // Проверка один элемент если
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        ListNode mid = null; //Середина нашего листа

        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        mid.next = null; //обрываем связь для списка. Получается два списка один head, который содержит от первого элемента до мид,
        //и второй список slow, потому-что указатель slow дошел (середины +1 = след.элемент после середины) и его начало оборвано указателем mid
        //по факту получается два разных списка.

        //Divide and Conquer
        ListNode part1 = sortList(head); //При первом вызове передаем сюда head с элементам [4,2]
        ListNode part2 = sortList(slow); //При первом вызове передаем сюда head с элементам [1,3]

        return merge(part1, part2);
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
