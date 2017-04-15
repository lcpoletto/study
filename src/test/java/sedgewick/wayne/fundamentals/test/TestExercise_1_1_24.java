package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_24;

/**
 * Test fixture for {@link Exercise_1_1_24}.
 */
public class TestExercise_1_1_24 {

    @Test
    public void testEmpty() {
        int result = Exercise_1_1_24.gcd(105, 24);
        Assert.assertEquals(3, result);
        result = Exercise_1_1_24.gcd(1111111, 1234567);
        Assert.assertEquals(1, result);
    }
}
