package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.adts.FixedCapacityQueueOfStrings;
import sedgewick.wayne.adts.ResizingArrayQueue;

/**
 * Created by poletto on 5/24/2017.
 */
public class TestExercise_1_3_14 {

    private static final String FIRST = "first";
    private static final String SECOND = "second";


    @Test
    public void testFixedQueue() {
        final FixedCapacityQueueOfStrings queue = new FixedCapacityQueueOfStrings(2);

        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());

        queue.enqueue(FIRST);
        Assert.assertFalse(queue.isEmpty());

        queue.enqueue(SECOND);
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(FIRST, queue.dequeue());
        Assert.assertEquals(SECOND, queue.dequeue());
    }

    @Test
    public void testResizingQueue() {
        final ResizingArrayQueue<String> queue = new ResizingArrayQueue<>(1);
        Assert.assertTrue(queue.isEmpty());

        queue.enqueue(FIRST);
        Assert.assertFalse(queue.isEmpty());

        try {
            queue.enqueue(SECOND);
            Assert.assertFalse(queue.isEmpty());
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail("Must not throw index out of bounds.");
        }

        Assert.assertEquals(FIRST, queue.dequeue());
        Assert.assertEquals(SECOND, queue.dequeue());
    }
}
