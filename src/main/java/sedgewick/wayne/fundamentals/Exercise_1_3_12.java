package sedgewick.wayne.fundamentals;

import sedgewick.wayne.adts.Queue;
import sedgewick.wayne.adts.Stack;

/**
 * 1.3.12 Write an iterable Stack client that has a static method copy() that takes a stack
 * of strings as argument and returns a copy of the stack. Note : This ability is a prime
 * example of the value of having an iterator, because it allows development of such functionality
 * without changing the basic API.
 */
public class Exercise_1_3_12 {

    public static Stack<String> copy(final Stack<String> stack) {
        if (stack == null) {
            return null;
        }
        final Stack<String> temporary = new Stack<>();
        final Stack<String> result = new Stack<>();
        for (String item : stack) {
            temporary.push(item);
        }
        for (String item : temporary) {
            result.push(item);
        }
        return result;
    }
}
