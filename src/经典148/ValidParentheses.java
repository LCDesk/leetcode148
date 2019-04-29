package 经典148;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char ch1, char ch2) {
        if (ch1 == '(') {
            return ch2 == ')';
        }
        if (ch1 == '[') {
            return ch2 == ']';
        }
        if (ch1 == '{') {
            return ch2 == '}';
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        v.isValid("()[]{}");

    }
}
