package sedgewick.wayne.adts;

import java.util.Iterator;

/**
 * Stack data type defined on page 121 of the book.
 */
public class Stack<T> implements Iterable<T> {

    private Node first;
    private int entries;

    private class Node {
        T item;
        Node next;
    }

    public void push(T t) {
        final Node oldFirst = first;
        first = new Node();
        first.item = t;
        first.next = oldFirst;
        entries++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        final T result = first.item;
        first = first.next;
        entries--;
        return result;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return entries;
    }

    /**
     * 1.3.7 Add a method peek() to Stack that returns the most recently inserted item on
     * the stack (without popping it).
     * @return most recently inserted item on the stack
     */
    public T peek() {
        if (!isEmpty()) {
            return first.item;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            final T result = current.item;
            current = current.next;
            return result;
        }
    }
}
