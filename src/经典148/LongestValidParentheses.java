package 经典148;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int count = 0;
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 0;
                start = i;
            } else if (count == 0) {
                res = Math.max(res, i - start);
            }
        }
        start = s.length();
        count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 0;
                start = i;
            } else if (count == 0) {
                res = Math.max(res, start - i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses(")()())"));
    }

}
