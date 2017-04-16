package sedgewick.wayne.adts;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Bag abstract data type defined on page 121 of the book.
 */
public class Bag<T> implements Iterable<T> {

    private Node first;
    private int entries;

    private class Node {
        T item;
        Node next;
    }

    public void add(T t) {
        final Node oldFirst = first;
        first = new Node();
        first.item = t;
        first.next = oldFirst;
        entries++;
    }

    public boolean isEmpty() {
        return first == null; // or entries == 0;
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
