package sedgewick.wayne.adts;

/**
 * ADT Created to answer linked list exercises starting on 1.3.19.
 * <p>
 * Created by poletto on 5/24/2017.
 */
public class LinkedList<T> {

    private Node first;
    private int entries;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return entries == 0;
    }

    public int size() {
        return entries;
    }

    /**
     * 1.3.19 Give a code fragment that removes the last node in a linked list whose first node
     * is first.
     *
     * @return
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node current = first;
        Node prev = first;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        // now current is the last element, thus we remove the link to it
        prev.next = null;
        entries--;
        return current.item;
    }

    /**
     * 1.3.20 Write a method delete() that takes an int argument k and deletes the kth element
     * in a linked list, if it exists.
     *
     * @param index
     * @return
     */
    public T delete(final int index) {
        if (index > entries) {
            return null;
        }
        Node current = first;
        Node previous = first;
        for (int i = 0; i < index - 1; i++) {
            previous = current;
            current = current.next;
        }
        // now current is pointing to the kth element, thus we can return it and remove the link
        previous.next = current.next;
        entries--;
        return current.item;
    }

    /**
     * 1.3.21 Write a method find() that takes a linked list and a string key as arguments
     * and returns true if some node in the list has key as its item field, false otherwise.
     *
     * @param key
     * @return
     */
    public boolean find(T key) {
        if (isEmpty()) {
            return false;
        }

        Node current = first;
        while (current != null) {
            if (key.equals(current.item)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 1.3.24 Write a method removeAfter() that takes a linked-list Node as argument and
     * removes the node following the given one (and does nothing if the argument or the next
     * field in the argument node is null).
     *
     * @param n
     * @return
     */
    public T removeAfter(Node n) {
        if (isEmpty() || n == null) {
            return null;
        }
        Node current = first;
        while (current != null && !current.item.equals(n.item)) {
            current = current.next;
        }
        // now we have current pointing to the correct element, we will remove the next one if available
        if (current.next != null) {
            final T result = current.next.item;
            current.next = current.next.next;
            entries--;
            return result;
        }
        // element not found, returning null
        return null;
    }
}
