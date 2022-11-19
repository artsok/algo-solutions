package io.sokovets.theory.linked_list;

public class LinkedList_Add {

    Node head;

    public class Node {
        int val;
        Node next;
    }

    LinkedList_Add() {
        head = null;
    }

    /**
     * Добавляем элемент в конец LinkedList
     *
     * @param a
     */
    public void addElement(int a) {
        Node nodeToAdd = new Node();
        nodeToAdd.val = a;

        Node temp = head;
        while (temp != null) {
            temp = temp.next;
        }
        temp.next = nodeToAdd;
    }

    /**
     * Добавить новый элемент с головы
     *
     * @param position
     * @param value
     */
    public void addElementToPosition(int position, int value) {
        int count = 0;

        if (position < 1) {
            throw new RuntimeException("такое не обрабатываем");
        }

        Node newNode = new Node();
        newNode.val = value;

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node curr = head;

            for (int i = 1; i < position -1; i++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            //Вот здесь идет подмена ссылок. Мы стоим на предыдущей Node, а не на current;
            if (curr != null) {
                newNode.next = curr.next;
                curr.next = newNode;
            }



        }
    }
}
