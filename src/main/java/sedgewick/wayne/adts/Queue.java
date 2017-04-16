package sedgewick.wayne.adts;

import java.util.Iterator;

/**
 * Queue data type defined on page 121 of the book.
 */
public class Queue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int entries;

    private class Node {
        T item;
        Node next;
    }

    // on queues we insert at the end of the list
    public void enqueue(T t) {
        final Node oldLast = last;
        last = new Node();
        last.item = t;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        entries++;
    }

    public T dequeue() {
        final T result = first.item;
        first = first.next;
        entries--;
        if (isEmpty()) {
            last = null;
        }
        return result;
    }

    public boolean isEmpty() {
        return first == null; // or entries == 0
    }

    public int size() {
        return entries;
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
