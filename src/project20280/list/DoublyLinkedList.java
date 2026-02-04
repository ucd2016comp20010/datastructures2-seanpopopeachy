package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    private static class Node<E> {
        private final E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.next = tail;
    }

    private void addBetween(E e, Node<E> pred, Node<E> succ) {
        if (head == null) return;


        Node<E> current = head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public E get(int i) {
        if (isEmpty()) return null;
        else if (i < size/2) {
            Node<E> current = head.next;

            for (int j = 0; j < i; j++) {
                current = current.next;
            }

            return current.data;
        } else {
            Node<E> current = tail.prev;

            for (int j = 0; j < (size - 1 - i); j++) {
                current = current.prev;
            }

            return current.data;
        }
    }

    @Override
    public void add(int i, E e) {
        Node<E> current;
        if (isEmpty()) return;
        else if (i < size/2) {
            current = head.next;

            for (int j = 0; j < i; j++) {
                current = current.next;
            }
        } else {
            current = tail.prev;

            for (int j = 0; j < (size - 1 - i); j++) {
                current = current.prev;
            }
        }

        Node<E> newNode = new Node<>(e, current.prev, current);
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    @Override
    public E remove(int i) {
        Node<E> current;
        if (isEmpty()) return null;
        else if (i < size/2) {
            current = head.next;

            for (int j = 0; j < i; j++) {
                current = current.next;
            }
        } else {
            current = tail.prev;

            for (int j = 0; j < (size - 1 - i); j++) {
                current = current.prev;
            }
        }
        E removed = current.data;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
        return removed;
    }

    private class DoublyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head.next;

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
        return new DoublyLinkedListIterator<E>();
    }

    private E remove(Node<E> n) {
        if (n == null) return null;


        Node<E> before = n.prev;
        Node<E> after = n.next;

        if (before != null) {
            before.next = after;
        } else {
            head = after;
        }

        if (after != null) {
            after.prev = before;
        } else {
            tail = before;
        }

        size--;

        E removed = n.data;

        return removed;
    }

    public E first() {
        if (isEmpty()) return null;

        return head.next.getData();
    }

    public E last() {
        if (isEmpty()) return null;

        return tail.prev.getData();
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(head.next);
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(tail.prev);
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head.next;
        while (curr != tail) {
            sb.append(curr.data);
            curr = curr.next;
            if (curr != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(-1);
        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }
    }
}