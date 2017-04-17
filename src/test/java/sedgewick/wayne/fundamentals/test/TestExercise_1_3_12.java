package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.adts.Stack;
import sedgewick.wayne.fundamentals.Exercise_1_3_12;

/**
 * Test fixture for {@link sedgewick.wayne.fundamentals.Exercise_1_3_12}.
 */
public class TestExercise_1_3_12 {

    @Test
    public void testNullEmpty() {
        Assert.assertNull(Exercise_1_3_12.copy(null));
        final Stack<String> result = Exercise_1_3_12.copy(new Stack<>());
        Assert.assertNotNull(result);
        Assert.assertEquals(true, result.isEmpty());
    }

    @Test
    public void testWithItems() {
        final Stack<String> input = new Stack<>();
        input.push("first");
        input.push("second");
        input.push("third");
        final Stack<String> result = Exercise_1_3_12.copy(input);
        Assert.assertNotEquals(input, result);
        Assert.assertEquals(input.size(), result.size());
        Assert.assertEquals(input.pop(), result.pop());
        Assert.assertEquals(input.pop(), result.pop());
        Assert.assertEquals(input.pop(), result.pop());
    }
}
