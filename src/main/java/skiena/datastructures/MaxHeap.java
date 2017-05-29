package skiena.datastructures;

/**
 * Defined on page 112 of the book. A max heap is a complete binary tree which the parent is always greater than
 * any of it's children.
 * <p>
 * Created by poletto on 5/28/2017.
 */
public class MaxHeap<T extends Comparable<T>> {

    private final T[] data;
    private int entries;

    /**
     * Defines a new heap with the received height, this will make possible to insert <code>(2^height) + 1</code>
     * elements into the heap.
     *
     * @param height maximum heap height
     */
    public MaxHeap(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("Heap needs at least 1 height");
        }
        // we do 2^height+1 here because we're going to ignore position 0 of the array to make operations
        // easier
        data = (T[]) new Comparable[(int) Math.pow(2, height + 1)];

        // we start entries with 1 because we're not going to use first position on the array
        entries = 1;
    }

    /**
     * Inserts a new item on this heap.
     *
     * @param item item to be inserted.
     */
    public void insert(T item) {
        if (entries >= data.length) {
            throw new ArrayIndexOutOfBoundsException("The heap is full.");
        }
        final int entryIndex = entries;
        data[entries++] = item;
        // if the newly inserted item is bigger then it's parent, then it needs to be swapped with the parent
        bubbleUp(entryIndex);
    }

    /**
     * Removes the biggest element from the heap maintaining it's balance.
     *
     * @return the biggest element on this heap
     */
    public T extractMax() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty.");
        }
        final T result = data[1];
        // move last element of the heap into first position and cascade changes
        data[1] = data[--entries];
        bubbleDown(1);
        return result;
    }

    /**
     * Getter for the element at index <code>index</code>.
     *
     * @param index element index to get
     * @return the element at the position
     */
    public T get(int index) {
        if (index > size()) {
            throw new ArrayIndexOutOfBoundsException("Provided index not available");
        }
        return data[index];
    }

    /**
     * Capacity returns the amount of data this heap can hold.
     *
     * @return heap capacity
     */
    public int capacity() {
        return data.length - 1;
    }

    /**
     * Size returns the current number of elements inside the heap.
     *
     * @return the size of the heap
     */
    public int size() {
        return entries - 1;
    }

    /**
     * <code>isEmpty</code> checks whether the heap is empty or not.
     *
     * @return <code>true</code> if empty and <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /*
     * PRIVATE METHODS
     */
    private void swap(int i, int j) {
        T aux = data[i];
        data[i] = data[j];
        data[j] = aux;
    }

    private int parent(int index) {
        if (index == 1) {
            return -1;
        }
        return index / 2;
    }

    private int maxChild(int index) {
        int firstIndex = index * 2;
        if (firstIndex <= entries) {
            int maxChild = firstIndex;
            if (firstIndex + 1 <= entries) {
                if (data[firstIndex].compareTo(data[firstIndex + 1]) < 0) {
                    // second child is bigger, let's use it
                    maxChild = firstIndex + 1;
                }
            }
            if (data[maxChild].compareTo(data[index]) > 0) {
                // child is bigger then parent, return it
                return maxChild;
            }
        }
        // this index don't have any child
        return -1;
    }

    private void bubbleUp(int entryIndex) {
        final int parentIndex = parent(entryIndex);
        if (parentIndex != -1) {
            T parent = data[parentIndex];
            T entry = data[entryIndex];
            if (parent.compareTo(entry) < 0) {
                swap(parentIndex, entryIndex);
                // now the entryIndex is the parentIndex, let's bubble up higher
                bubbleUp(parentIndex);
            }
        }
    }

    private void bubbleDown(int index) {
        final int childIndex = maxChild(index);
        if (childIndex != -1) {
            swap(index, childIndex);
            bubbleDown(childIndex);
        }
    }


}
