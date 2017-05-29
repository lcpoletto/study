package skiena.datastructures.test;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import skiena.datastructures.MaxHeap;

/**
 * Created by poletto on 5/28/2017.
 */
public class TestMaxHeap {

    @Test
    public void testCapacity() {
        for (int i = 1; i <= 10; i++) {
            MaxHeap<Integer> heap = new MaxHeap<>(i);
            Assert.assertEquals((int) Math.pow(2, i + 1) - 1, heap.capacity());
        }
    }

    @Test
    public void testInsert() {
        MaxHeap<Integer> heap = new MaxHeap<>(1);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        Assert.assertEquals(Integer.valueOf(3), heap.get(1));
        Assert.assertEquals(Integer.valueOf(1), heap.get(2));
        Assert.assertEquals(Integer.valueOf(2), heap.get(3));
    }

    @Test
    public void testMaxHeapSort() {
        MaxHeap<Integer> heap = new MaxHeap<>(3);
        final int capacity = heap.capacity();
        for (int i = 0; i < capacity; i++) {
            heap.insert(StdRandom.uniform(capacity * 3));
        }

        while (heap.size() > 1) {
            Integer first = heap.extractMax();
            Integer second = heap.extractMax();
            Assert.assertTrue("Must be reverse ordered: ", first.compareTo(second) >= 0);
            System.out.printf("%d %d ", first, second);
        }
        System.out.println("Done.");
    }
}
