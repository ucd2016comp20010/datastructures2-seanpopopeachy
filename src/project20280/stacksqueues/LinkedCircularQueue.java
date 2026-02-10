package project20280.stacksqueues;

import project20280.interfaces.Queue;import project20280.list.CircularlyLinkedList;

/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class LinkedCircularQueue<E> implements Queue<E> {

    private final CircularlyLinkedList<E> list;

    public LinkedCircularQueue() {
        list = new CircularlyLinkedList<>();
    }

    public static void main(String[] args) {
        LinkedCircularQueue<Integer> cq = new LinkedCircularQueue<>();
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);

        System.out.println("Before rotate: " + cq); // [1, 2, 3]
        cq.rotate();
        System.out.println("After rotate:  " + cq); // [2, 3, 1]
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    public void rotate() {
        list.rotate();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
