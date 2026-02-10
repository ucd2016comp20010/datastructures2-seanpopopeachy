package project20280.exercises;

import project20280.list.SinglyLinkedList;

import java.util.Arrays;

public class Wk1 {

    public static class Node<E extends Comparable<E>> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public static <E extends Comparable<E>> Node<E> sortedMerge(Node<E> l1, Node<E> l2) {

//        Write a function which merges two sorted linked lists.
//        l1 = {2, 6, 20, 24};
//        l2 = {1, 3, 5, 8, 12, 19, 25};
//
//        result = l1. sortedMerge (l2);
//        ( result = {1, 2, 3, 5, 6, 8, 12, 19, 20, 24, 25}; )

        Node<E> dummy = new Node<>(null);
        Node<E> tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data.compareTo(l2.data) <= 0) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }

    public static void printList(Node<Integer> head){
        while (head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String [] args) {
        // List 1: 2 -> 6 -> 20 -> 24
        Node<Integer> l1 = new Node<>(2);
        l1.next = new Node<>(6);
        l1.next.next = new Node<>(20);
        l1.next.next.next = new Node<>(24);

        // List 2: 1 -> 3 -> 5 -> 8 -> 12 -> 19 -> 25
        Node<Integer> l2 = new Node<>(1);
        l2.next = new Node<>(3);
        l2.next.next = new Node<>(5);
        l2.next.next.next = new Node<>(8);
        l2.next.next.next.next = new Node<>(12);
        l2.next.next.next.next.next = new Node<>(19);
        l2.next.next.next.next.next.next = new Node<>(25);

        Node<Integer> result = sortedMerge(l1, l2);
        printList(result);
    }
}
