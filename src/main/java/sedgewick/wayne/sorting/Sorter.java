package sedgewick.wayne.sorting;

/**
 * Created by poletto on 5/26/2017.
 */
public abstract class Sorter<T extends Comparable<T>> {

    protected boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected void show(T[] a) {
        for (T t : a) {
            System.out.printf("%s ", t);
        }
        System.out.println("");
    }

    protected boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public abstract void sort(T[] a);
}
