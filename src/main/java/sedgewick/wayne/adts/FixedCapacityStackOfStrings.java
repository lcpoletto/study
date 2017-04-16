package sedgewick.wayne.adts;

/**
 * Created by poletto on 4/15/2017.
 */
public class FixedCapacityStackOfStrings {

    private String[] a; // stack entries
    private int N; // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isFull() {
        return N == a.length;
    }
}
