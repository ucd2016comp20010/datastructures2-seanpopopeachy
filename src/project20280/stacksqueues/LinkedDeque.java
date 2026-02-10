package project20280.stacksqueues;

import project20280.interfaces.Deque;
import project20280.list.DoublyLinkedList;

public class LinkedDeque<E> implements Deque<E> {

    DoublyLinkedList<E> ll;

    public LinkedDeque() {
        ll = new DoublyLinkedList<>();
    }

    public static void main(String[] args) {
        LinkedDeque<Integer> deq = new LinkedDeque<>();
        deq.addFirst(2);
        deq.addLast(3);
        deq.addFirst(1);
        System.out.println(deq);        // Should show [1, 2, 3]
        System.out.println(deq.last()); // Should show 3
        deq.removeFirst();
        System.out.println(deq);        // Should show [2, 3]
    }

    @Override
    public int size() {
        return ll.size();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public E first() {
        return ll.first();
    }

    @Override
    public E last() {
        return ll.last();
    }

    @Override
    public void addFirst(E e) {
        ll.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        ll.addLast(e);
    }

    @Override
    public E removeFirst() {
        return ll.removeFirst();
    }

    @Override
    public E removeLast() {
        return ll.removeLast();
    }

    public String toString() {
        return ll.toString();
    }
}
