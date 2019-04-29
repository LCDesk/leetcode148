package 经典148;

import java.util.Stack;

/**
 * 单调栈的应用
 */
public class MaximalRectangle {
    //直方图勾勒出的最大长方形
    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        stack.push(0);
        int max = 0;
        int i = 1;
        for (; i < heights.length; i++) {
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] < heights[stack.peek()]) {
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    int index = stack.pop();
                    int area = (i - stack.peek() - 1) * heights[index];
                    max = Math.max(max, area);
                }
                stack.push(i);
            } else {
                stack.pop();
                stack.push(i);
            }
        }
        while (stack.peek() != -1 && !stack.isEmpty()) {
            int index = stack.pop();
            int area = (i - stack.peek() - 1) * heights[index];
            max = Math.max(max, area);
        }
        return max;
    }


    //每一行看成直方图找最大面积
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return 0;
        }
        int[] num = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '0') {
                    num[j] += 1;
                } else {
                    num[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(num));
        }
        return max;
    }


    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        System.out.println(m.largestRectangleArea(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 2147483647}));
    }
}
