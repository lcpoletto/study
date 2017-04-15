package sedgewick.wayne.fundamentals;

/**
 * 1.1.14 Write a static method lg() that takes an int value N as argument and returns
 * the largest int not larger than the base-2 logarithm of N. Do not use Math.
 */
public class Exercise_1_1_14 {

    public static int lg(int number) {
        // basic cases
        if (number < 2) {
            return 0;
        }
        int result = 1;
        // as we want to return the previous largest number we need to return before we
        // go too high
        while (twoOnPower(result + 1) <= number) {
            result++;
        }
        // if the number is a power of 2 we should return the power
        return result;
    }

    private static int twoOnPower(int power) {
        if (power == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= 2;
        }
        return result;
    }
}
