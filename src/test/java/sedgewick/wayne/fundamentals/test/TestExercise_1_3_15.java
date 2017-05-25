package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.adts.Queue;
import sedgewick.wayne.fundamentals.Exercise_1_3_15;

/**
 * Created by poletto on 5/24/2017.
 */
public class TestExercise_1_3_15 {

    @Test
    public void testExercise() {
        final Queue<Integer> queue = new Queue<>();
        final int size = 10;
        final int k = 4;

        for (int i = 0; i < size; i++) {
            queue.enqueue(i + 1);
        }

        final int result = Exercise_1_3_15.kthFromLast(k, queue);
        Assert.assertEquals(size - k, result);

    }
}
