package sedgewick.wayne.fundamentals;

/**
 * ADT Created to answer linked list exercises starting on 1.3.19.
 * <p>
 * Created by poletto on 5/24/2017.
 */
public class LinkedList<T extends Comparable> {

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
        Node previous = first;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        // current is the last element on the list
        if (current == first) {
            first = null;
        } else {
            previous.next = null;
        }
        entries--;
        return current.item;
    }

    /**
     * 1.3.20 Write a method delete() that takes an int argument k and deletes the kth element
     * in a linked list, if it exists.
     *
     * @param k
     * @return
     */
    public T delete(final int k) {
        if (k > entries) {
            return null;
        }
        Node current = first;
        Node previous = first;
        for (int i = 0; i < k; i++) {
            previous = current;
            current = current.next;
        }
        // now current is pointing to the kth element, thus we can return it and remove the link
        if (current == first) {
            first = null;
        } else {
            previous.next = current.next;
        }
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
            current = current.next;
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
        if (n == null || n.next == null) {
            return null;
        }
        T result = n.next.item;
        n.next = n.next.next;
        return result;
    }

    /**
     * 1.3.25 Write a method insertAfter() that takes two linked-list Node arguments and
     * inserts the second after the first on its list (and does nothing if either argument is null).
     *
     * @param first
     * @param second
     */
    public void insertAfter(Node first, Node second) {
        if (first != null && second != null) {
            second.next = first.next;
            first.next = second;
        }
    }

    /**
     * 1.3.27 Write a method max() that takes a reference to the first node in a linked list as
     * argument and returns the value of the maximum key in the list. Assume that all keys are
     * positive integers, and return 0 if the list is empty.
     *
     * @return
     */
    public T iterativeMax() {
        if (isEmpty()) {
            return null;
        }
        T max = first.item;
        Node current = first;
        while (current != null) {
            current = current.next;
            if (current.item.compareTo(max) > 0) {
                max = current.item;
            }
        }
        return max;
    }

    /**
     * 1.3.28 Develop a recursive solution to the previous question.
     *
     * @return
     */
    public T recursiveMax() {
        if (isEmpty()) {
            return null;
        }
        return recursiveMax(first, first.item);
    }

    private T recursiveMax(Node n, T max) {
        T curMax = n.item.compareTo(max) > 0 ? n.item : max;
        if (n.next == null) {
            return curMax;
        }
        return recursiveMax(n.next, curMax);
    }
}
