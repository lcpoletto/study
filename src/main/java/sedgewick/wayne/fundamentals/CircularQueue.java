package sedgewick.wayne.fundamentals;

import java.util.Iterator;

/**
 * 1.3.29 Write a Queue implementation that uses a circular linked list, which is the same
 * as a linked list except that no links are null and the value of last.next is first whenever
 * the list is not empty. Keep only one Node instance variable (last).
 * <p>
 * Created by poletto on 5/26/2017.
 */
public class CircularQueue<T> implements Iterable<T> {

    private Node last;
    private int entries;

    private class Node {
        Node next;
        T item;
    }

    public void enqueue(T t) {
        if (t != null) {
            Node n = new Node();
            n.item = t;

            // when there is only 1 element, last and last.next will be pointing to the same object
            if (last == null) {
                // next after last is first, which is itself
                last.next = n;
            } else {
                // last.next is pointing to first, we need make this node point to it
                n.next = last.next;
                // now we repoint previous last node to point to new last
                last.next = n;
            }

            last = n;
            entries++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        // we always remove the first element on a queue, thus last.next
        T result = last.next.item;
        if (last.next == last) {
            // we only had 1 element and we're removing it, queue is empty now
            last = null;
        } else {
            // move to second on the queue
            last.next = last.next.next;
        }
        entries--;
        return result;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public int size() {
        return entries;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator();
    }

    private class CircularIterator implements Iterator<T> {
        Node current = last.next;
        boolean first = true;

        @Override
        public boolean hasNext() {
            if (last.next == last) {
                // there is only 1 element on the queue, thus we need to return true only once
                if (first) {
                    first = false;
                    return true;
                }
            }
            return current != last;
        }

        @Override
        public T next() {
            T result = current.item;
            current = current.next;
            return result;
        }
    }
}
