package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_3_4;

/**
 * Created by poletto on 4/15/2017.
 */
public class TestExercise_1_3_4 {

    @Test
    public void testBalanced() {
        final String balanced = "[()]{}{[()()]()}";
        final boolean result = Exercise_1_3_4.balanced(balanced);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testNotBalanced() {
        final String notBalanced = "[(])";
        final boolean result = Exercise_1_3_4.balanced(notBalanced);
        Assert.assertEquals(false, result);
    }
}
