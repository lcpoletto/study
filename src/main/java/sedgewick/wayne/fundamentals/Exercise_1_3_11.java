package sedgewick.wayne.fundamentals;

import sedgewick.wayne.adts.Stack;

/**
 * 1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard
 * input, evaluates it, and prints the value. (Piping the output of your program from
 * the previous exercise to this program gives equivalent behavior to Evaluate.
 */
public class Exercise_1_3_11 {

    public static double evaluatePostfix(final String input) {
        if (input == null || input.isEmpty()) {
            return Double.NaN;
        }

        final String[] items = input.split(" ");
        final Stack<String> operations = new Stack<>();
        final Stack<String> values = new Stack<>();

        for (final String item : items) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/") || item.equals("sqrt")) {
                operations.push(item);
            } else if (item.equals(")")) {
                String value = values.pop();
                String operation = operations.pop();

                if (operation.equals("+")) {
                    value = "" + (Double.valueOf(values.pop()) + Double.valueOf(value));
                } else if (operation.equals("-")) {
                    value = "" + (Double.valueOf(values.pop()) + Double.valueOf(value));
                } else if (operation.equals("*")) {
                    value = "" + (Double.valueOf(values.pop()) * Double.valueOf(value));
                } else if (operation.equals("/")) {
                    value = "" + (Double.valueOf(values.pop()) / Double.valueOf(value));
                } else if (operation.equals("sqrt")) {
                    value = "" + (Math.sqrt(Double.valueOf(value)));
                }

                values.push(value);
            } else {
                if (!item.equals("(")) {
                    values.push(item);
                }
            }
        }

        return Double.valueOf(values.pop());
    }

}
