package sedgewick.wayne.adts;

import java.util.Iterator;

/**
 * Created by poletto on 4/15/2017.
 */
public class ResizingArrayStack<T> implements Iterable <T> {

    private T[] data;
    private int entries;

    public ResizingArrayStack(final int capacity) {
        data = (T[]) new Object[capacity];
        entries = 0;
    }

    public boolean isEmpty() {
        return entries == 0;
    }

    public int size() {
        return entries;
    }

    public void push(T entry) {
        if (isFull()) {
            resize(data.length * 2);
        }
        data[entries++] = entry;
    }

    public T pop() {
        final T result = data[--entries];
        data[entries] = null;
        if (entries > 0 && entries <= data.length / 4) {
            resize(data.length / 2);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    /*
         * PRIVATE METHODS
         */
    private void resize(int max) {
        final T[] newData = (T[]) new Object[max];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private boolean isFull() {
        return entries == data.length;
    }

    /*
     * PRIVATE CLASSES
     */
    private class ReverseArrayIterator implements Iterator<T> {
        private int i = entries;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return data[--i];
        }
    }
}
