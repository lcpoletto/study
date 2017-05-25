package sedgewick.wayne.adts;

import java.util.Iterator;

/**
 * 1.3.14 Develop a class ResizingArrayQueueOfStrings that implements the queue
 * abstraction with a fixed-size array, and then extend your implementation to use array
 * resizing to remove the size restriction.
 * <p>
 * Created by poletto on 5/24/2017.
 */
public class ResizingArrayQueue<T> implements Iterable<T> {

    private T[] data;
    private int entries;

    public ResizingArrayQueue(final int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer.");
        }
        data = (T[]) new Object[capacity];
    }

    public void enqueue(final T item) {
        if (isFull()) {
            resize(data.length * 2);
        }
        data[entries++] = item;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty.");
        }
        final T result = data[0];
        entries--;
        if (entries < data.length / 4) {
            resize(data.length / 2);
        }
        System.arraycopy(data, 1, data, 0, data.length - 1);
        return result;
    }

    public boolean isEmpty() {
        return entries == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /*
     * PRIVATE METHODS
     */

    private void resize(final int max) {
        final T[] newData = (T[]) new Object[max];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private boolean isFull() {
        return entries == data.length;
    }

    /*
     * PRIVATE CLASSES
     */
    private class ArrayIterator implements Iterator<T> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < entries;
        }

        @Override
        public T next() {
            return data[i++];
        }
    }
}
