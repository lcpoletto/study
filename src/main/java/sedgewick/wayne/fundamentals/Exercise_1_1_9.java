package sedgewick.wayne.fundamentals;

/**
 * 1.1.9 Write a code fragment that puts the binary representation of a positive integer N
 * into a String s.
 */
public class Exercise_1_1_9 {

    public static String toBinaryString(int number) {
        if (number < 0) {
            return null;
        }
        if (number == 0) {
            return "0";
        }
        String result = "";
        for (int n = number; n > 0; n /= 2) {
            result = (n % 2) + result;
        }
        return result;
    }
}
