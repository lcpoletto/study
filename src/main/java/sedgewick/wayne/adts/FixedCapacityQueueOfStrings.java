package sedgewick.wayne.adts;

/**
 * 1.3.14 Develop a class ResizingArrayQueueOfStrings that implements the queue
 * abstraction with a fixed-size array, and then extend your implementation to use array
 * resizing to remove the size restriction.
 */
public class FixedCapacityQueueOfStrings {

    private String[] a; // queue of strings
    private int n; // elements

    public FixedCapacityQueueOfStrings(final int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity has to be positive.");
        }
        a = new String[cap];
    }

    public void enqueue(final String item) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is full.");
        }
        a[n++] = item;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty.");
        }
        // we return the first element and shift the whole array to the beginning
        final String result = a[0];
        System.arraycopy(a, 1, a, 0, a.length - 1);
        n--;
        return result;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == a.length;
    }

    public int size() {
        return n;
    }
}
