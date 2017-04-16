package sedgewick.wayne.fundamentals;

import sedgewick.wayne.adts.Stack;

/**
 * 1.3.4 Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced. For example,
 * your program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class Exercise_1_3_4 {

    public static boolean balanced(final String input) {
        final Stack<Character> stack = new Stack<>();
        final char[] inputChars = input.toCharArray();
        for (final char inputChar : inputChars) {
            if (inputChar == '(' || inputChar == '[' || inputChar == '{') {
                stack.push(inputChar);
            } else {
                final Character last = stack.pop();
                if (inputChar == ')') {
                    if (!last.equals('(')) {
                        return false;
                    }
                } else if (inputChar == ']') {
                    if (!last.equals('[')) {
                        return false;
                    }
                } else if (inputChar == '}'){
                    if (!last.equals('{')) {
                        return false;
                    }
                } else {
                    // character not recognized
                    return false;
                }
            }
        }
        return true;
    }

}
