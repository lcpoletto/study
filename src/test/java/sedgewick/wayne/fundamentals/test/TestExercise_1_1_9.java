package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_9;

/**
 * Test fixture for {@link Exercise_1_1_9}.
 */
public class TestExercise_1_1_9 {

    @Test
    public void testNegative() {
        final String result = Exercise_1_1_9.toBinaryString(-1);
        Assert.assertNull(result);
    }

    @Test
    public void testZero() {
        final String result = Exercise_1_1_9.toBinaryString(0);
        Assert.assertEquals("0", result);
    }

    @Test
    public void testPositive() {
        final String two = Exercise_1_1_9.toBinaryString(2);
        Assert.assertEquals("10", two);

        final String four = Exercise_1_1_9.toBinaryString(4);
        Assert.assertEquals("100", four);

        final String eight = Exercise_1_1_9.toBinaryString(8);
        Assert.assertEquals("1000", eight);

        final String three = Exercise_1_1_9.toBinaryString(3);
        Assert.assertEquals("11", three);

        final String five = Exercise_1_1_9.toBinaryString(5);
        Assert.assertEquals("101", five);

        final String nine = Exercise_1_1_9.toBinaryString(9);
        Assert.assertEquals("1001", nine);
    }
}
