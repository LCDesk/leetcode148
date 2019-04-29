package 经典148;

import java.util.Stack;

public class Evalute {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperation(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operate(a, b, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.peek();
    }

    private int operate(int a, int b, String operation) {
        if ("+".equals(operation)) {
            return a + b;
        } else if ("-".equals(operation)) {
            return a - b;
        } else if ("*".equals(operation)) {
            return a * b;
        } else {
            return a / b;
        }
    }

    private boolean isOperation(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

}
