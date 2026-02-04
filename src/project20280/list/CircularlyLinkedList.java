package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

        private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            data = e;
            next = n;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if (isEmpty()) {
            return null;
        }

        Node<E> current = tail.getNext();

        for(int j = 0; j < i; j++) {
            current = current.getNext();
        }

        return current.getData();
    }

    /**
     * Inserts the given element at the specified index of the list, shifting all
     * subsequent elements in the list one position further to make room.
     *
     * @param i the index at which the new element should be stored
     * @param e the new element to be stored
     */
    @Override
    public void add(int i, E e) {
        if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> current = tail.getNext();

            for (int j = 0; j < i - 1; j++) {
                current = current.getNext();
            }

            current.setNext(new Node<>(e, current.getNext()));
            size++;
        }
    }

    @Override
    public E remove(int i) {
        Node<E> prev = tail;

        for(int j = 0; j < i; j++) {
            prev = prev.next;
        }

        E removed = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return removed;
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    private class CircularlyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) tail;

        @Override
        public boolean hasNext() {
            return curr != tail;
        }

        @Override
        public E next() {
            E res = curr.data;
            curr = curr.next;
            return res;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<E>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            E removed = tail.getNext().getData();
            tail.setNext(tail.getNext().getNext());
            size--;
            return removed;
        }
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(size - 1);
    }

    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
        }

        size++;
    }

    @Override
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = tail;
        do {
            curr = curr.next;
            sb.append(curr.data);
            if (curr != tail) {
                sb.append(", ");
            }
        } while (curr != tail);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
        for (int i = 10; i < 20; ++i) {
            ll.addLast(i);
        }

        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        ll.rotate();
        System.out.println(ll);

        ll.removeFirst();
        ll.rotate();
        System.out.println(ll);

        ll.removeLast();
        ll.rotate();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }

    }
}
