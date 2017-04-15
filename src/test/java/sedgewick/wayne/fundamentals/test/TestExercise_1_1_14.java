package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_14;

/**
 * Test fixture for {@link Exercise_1_1_14}.
 */
public class TestExercise_1_1_14 {

    @Test
    public void testBaseCases() {
        int result = Exercise_1_1_14.lg(-1);
        Assert.assertEquals(0, result);
        result = Exercise_1_1_14.lg(0);
        Assert.assertEquals(0, result);
        result = Exercise_1_1_14.lg(1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testRegularCases() {
        int result = Exercise_1_1_14.lg(2);
        Assert.assertEquals(1, result);
        result = Exercise_1_1_14.lg(3);
        Assert.assertEquals(1, result);
        result = Exercise_1_1_14.lg(4);
        Assert.assertEquals(2, result);
        result = Exercise_1_1_14.lg(32);
        Assert.assertEquals(5, result);
        result = Exercise_1_1_14.lg(63);
        Assert.assertEquals(5, result);
    }
}
