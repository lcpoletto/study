package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_2_6;

/**
 * Created by poletto on 4/15/2017.
 */
public class TestExercise_1_2_6 {

    @Test
    public void testBaseCases() {
        boolean result = Exercise_1_2_6.areCircular(null, null);
        Assert.assertEquals(false, result);
        result = Exercise_1_2_6.areCircular("", "");
        Assert.assertEquals(false, result);
        result = Exercise_1_2_6.areCircular("one", "oneone");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testCircular() {
        boolean result = Exercise_1_2_6.areCircular("one", "one");
        Assert.assertEquals(true, result);
        result = Exercise_1_2_6.areCircular("abcdef", "defabc");
        Assert.assertEquals(true, result);
        result = Exercise_1_2_6.areCircular("abcdef", "defabb");
        Assert.assertEquals(false, result);
    }
}
