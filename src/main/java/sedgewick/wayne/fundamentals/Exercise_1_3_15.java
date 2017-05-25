package sedgewick.wayne.fundamentals;

import sedgewick.wayne.adts.Queue;

import java.util.Collection;

/**
 * 1.3.15 Write a Queue client that takes a command-line argument k and prints the kth
 * from the last string found on standard input (assuming that standard input has k or
 * more strings).
 * <p>
 * Created by poletto on 5/24/2017.
 */
public class Exercise_1_3_15 {

    public static <T> T kthFromLast(final int k, final Queue<T> queue) {
        T result = null;
        while (queue.size() > k) {
            result = queue.dequeue();
        }
        return result;
    }

}
